/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.controller.munduscreator;

import edu.sena.entity.munduscreator.Usuarios;
import edu.sena.facade.munduscreator.UsuariosFacadeLocal;
import edu.sena.service.munduscreator.MailService;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.mail.MessagingException;

import org.primefaces.PF;

@Named(value = "usuarioSession")
@SessionScoped
public class UsuarioSession implements Serializable {

    private Usuarios UsuReg = new Usuarios();
    private Usuarios UsuLog = new Usuarios();
    private Usuarios UsuExt = new Usuarios();
    private String correoForm;
    private String cooreoSend;
    private String claveForm;
    private String Mensaje;
    private String vConstrasenha;
    private String asunto;
    private String encabezado;
    private MailService ms = new MailService();
    private List<String> listaTipDoc;
    private List<String> listaGenero;

    @EJB
    UsuariosFacadeLocal ufl;

    public UsuarioSession() {
        listaTipDoc = new ArrayList<>();
        listaTipDoc.add("CC");
        listaTipDoc.add("TI");
        listaTipDoc.add("CE");

        listaGenero = new ArrayList<>();
        listaGenero.add("Masculino");
        listaGenero.add("Femenino");
        listaGenero.add("Otro");

    }
    
    public static boolean claveSegura(String clave){
        boolean result = false;
        boolean mayus = false;
        boolean numero =false;
            if (clave.length()>8) {
                
                char c;
                
                for(int i=0; i<clave.length(); i++){
                    
                    c = clave.charAt(i);
                    if (Character.isDigit(c)) {
                        numero = true;
                    }
                    if(Character.isUpperCase(c)){
                        mayus = true;
                    }
                }
                
                if (numero && mayus) {
                    result=true;
                }else{
                    result= false;
                }
     }
      return result;
    }

    public void crearUsuario() {
        boolean comprobar = claveSegura(UsuReg.getUSUContrasenha());
        try {
            if (comprobar) {
            UsuReg.setUSUEstado(Short.parseShort("1"));
            UsuReg.setUSUFoto(String.valueOf("https://t4.ftcdn.net/jpg/02/15/84/43/360_F_215844325_ttX9YiIIyeaR7Ne6EaLLjMAmy4GvPC69.jpg"));
            ufl.create(UsuReg);
            ufl.asignaRol(UsuReg.getPKUSUId(), 1);
            ms.sendMessageRegister(UsuReg.getUSUCorreo(), UsuReg.getUSUNombre(),UsuReg.getUSUApellido());
            ms = new MailService();
            UsuLog = ufl.validarUsuario(UsuReg.getUSUCorreo(), UsuReg.getUSUContrasenha());
            FacesContext fx = FacesContext.getCurrentInstance();
            fx.getExternalContext().redirect("Estudiante/Index.xhtml");
            UsuReg = new Usuarios();
            }else{
            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'error',"
                    + "  title: 'Valide su contraseña',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");
            }
        } catch (Exception e) {
            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'error',"
                    + "  title: 'Valide sus datos',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");
        }

    }

    public void validarUsuario() {
        try {
            UsuLog = ufl.validarUsuario(correoForm, claveForm);
            if (UsuLog == null) {
                PF.current().executeScript(
                        "  swal.fire({"
                        + "  position: 'top-center',"
                        + "  icon: 'warning',"
                        + "  title: 'Usuario no encontrado',"
                        + "  showConfirmButton: false,"
                        + "  timer: 1500"
                        + "  })");
            } else {
                if (UsuLog.getUSUEstado() == Short.parseShort("1")) {
                    FacesContext fx = FacesContext.getCurrentInstance();
                    fx.getExternalContext().redirect("Estudiante/Index.xhtml");
                } else {
                    PF.current().executeScript(
                            "  swal.fire({"
                            + "  position: 'top-center',"
                            + "  icon: 'info',"
                            + "  title: 'Contacte al administrador',"
                            + "  showConfirmButton: false,"
                            + "  timer: 1500"
                            + "  })");

                }
            }
        } catch (Exception e) {
            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'error',"
                    + "  title: 'Valide sus datos',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");
        }
    }

    public void editarMiPefil() {
        try {
            ufl.edit(UsuLog);

            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'success',"
                    + "  title: 'Actualizado',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");
        } catch (Exception e) {
            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'error',"
                    + "  title: 'Intente Nuevamente',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");
        }
    }

    public void eliminarMiPefil() throws IOException {
        try {
            ufl.remove(UsuLog);
            FacesContext.getCurrentInstance().getExternalContext().redirect("../index.xhtml");
            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'warning',"
                    + "  title: 'Cuenta eliminada',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");

        } catch (Exception e) {

            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'Error',"
                    + "  title: 'Valide los campos',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");

        }

    }

    public void recuperarContrasenha() {
        try {
            UsuLog = ufl.recovery(cooreoSend);
            if (UsuLog == null) {
               PF.current().executeScript(
                        "  swal.fire({"
                        + "  position: 'top-center',"
                        + "  icon: 'warning',"
                        + "  title: 'Usuario no encontrado',"
                        + "  showConfirmButton: false,"
                        + "  timer: 1500"
                        + "  })");
            } else {
                ms.sendMessageRecovery(cooreoSend, UsuLog.getUSUContrasenha());
                PF.current().executeScript(
                        "  swal.fire({"
                        + "  position: 'top-center',"
                        + "  icon: 'success',"
                        + "  title: 'Correo de recuperación enviado',"
                        + "  showConfirmButton: false,"
                        + "  timer: 1500"
                        + "  })");
                ms = new MailService();
                cooreoSend="";
            }
        } catch (Exception e) {
            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'error',"
                    + "  title: 'Valide sus datos',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");
        }
    }

    public List<Usuarios> leerTodos() {
        return ufl.leerTodos();
    }

    public void crearUsuarioAdmin() {
        try {
            UsuReg.setUSUEstado(Short.parseShort("1"));
            UsuReg.setUSUFoto(String.valueOf("https://t4.ftcdn.net/jpg/02/15/84/43/360_F_215844325_ttX9YiIIyeaR7Ne6EaLLjMAmy4GvPC69.jpg"));
            ufl.create(UsuReg);
            ufl.asignaRol(UsuReg.getPKUSUId(), 1);
            
            ms = new MailService();
        } catch (Exception e) {
            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'error',"
                    + "  title: 'Valide sus datos',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");
        }

    }

    public void encontrarUsuario(Usuarios us) throws IOException {
        this.UsuExt = us;
        FacesContext.getCurrentInstance().getExternalContext().redirect("EditarDatos.xhtml");
    }

    public void editarPefilExt() {
        try {
            ufl.edit(UsuExt);

            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'success',"
                    + "  title: 'Actualizado',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");
        } catch (Exception e) {
            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'error',"
                    + "  title: 'Intente Nuevamente',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");
        }
    }

    public void eliminarPefilExt() throws IOException {
        try {
            ufl.remove(UsuExt);
            FacesContext.getCurrentInstance().getExternalContext().redirect("Index.xhtml");
            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'warning',"
                    + "  title: 'Cuenta eliminada',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");
        } catch (Exception e) {

            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'error',"
                    + "  title: 'Valide los campos',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");
        }

    }

    public void sendMessageMasivo() {
        try {
            //List<String>email=new ArrayList<>();//para 1 usuario
            //email.add(Correo.getUSUCorreo());//para 1 usuario
            //ms.sendMessage(Mensaje,email);//para 1 usuario
            ms.sendMessageMasivo(encabezado,asunto, Mensaje, ufl.getAllCorreos());// para correo masivo
            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'success',"
                    + "  title: 'Correo enviado',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");
            ms = new MailService();
            Mensaje="";
            asunto="";
            encabezado="";
        } catch (MessagingException e) {
            System.out.println(e.getMessage());
            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'error',"
                    + "  title: 'Ocurrió un error',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");
        }
    }

    public void sendMessage() {
        try {
            ms.sendMessage(Mensaje, cooreoSend, asunto);
            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'success',"
                    + "  title: 'Correo enviado',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");
            ms = new MailService();
            cooreoSend="";
            Mensaje="";
            asunto="";
        } catch (MessagingException e) {
            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'error',"
                    + "  title: 'Ocurrió un error',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");
        }
    }

    public Usuarios getUsuLog() {
        return UsuLog;
    }

    public void setUsuLog(Usuarios UsuLog) {
        this.UsuLog = UsuLog;
    }

    public String getCorreoForm() {
        return correoForm;
    }

    public void setCorreoForm(String correoForm) {
        this.correoForm = correoForm;
    }

    public String getClaveForm() {
        return claveForm;
    }

    public void setClaveForm(String claveForm) {
        this.claveForm = claveForm;
    }

    public Usuarios getUsuReg() {
        return UsuReg;
    }

    public void setUsuReg(Usuarios UsuReg) {
        this.UsuReg = UsuReg;
    }

    public Usuarios getUsuExt() {
        return UsuExt;
    }

    public void setUsuExt(Usuarios UsuExt) {
        this.UsuExt = UsuExt;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
    }

    public MailService getMs() {
        return ms;
    }

    public void setMs(MailService ms) {
        this.ms = ms;
    }

    public List<String> getListaTipDoc() {
        return listaTipDoc;
    }

    public void setListaTipDoc(List<String> listaTipDoc) {
        this.listaTipDoc = listaTipDoc;
    }

    public List<String> getListaGenero() {
        return listaGenero;
    }

    public void setListaGenero(List<String> listaGenero) {
        this.listaGenero = listaGenero;
    }

    public String getvConstrasenha() {
        return vConstrasenha;
    }

    public void setvConstrasenha(String vConstrasenha) {
        this.vConstrasenha = vConstrasenha;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getCooreoSend() {
        return cooreoSend;
    }

    public void setCooreoSend(String cooreoSend) {
        this.cooreoSend = cooreoSend;
    }

    public String getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(String encabezado) {
        this.encabezado = encabezado;
    }

}
