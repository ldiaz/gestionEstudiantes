package edu.ucc.gestionestudiantes.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.ucc.gestionestudiantes.domain.Evento;
import edu.ucc.gestionestudiantes.domain.Programa;
import edu.ucc.gestionestudiantes.servicios.ServicioEvento;
import edu.ucc.gestionestudiantes.servicios.ServicioPrograma;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
 
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.web.bind.annotation.RequestParam;

import ch.qos.logback.core.net.SyslogOutputStream;

import org.springframework.core.io.ClassPathResource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import java.util.HashMap;
import java.util.Map;


@Controller
public class controladorGeneralReportes{
	
	@Autowired
	private ServicioPrograma servPrograma;
	
	@Autowired
	private ServicioEvento servEvento;
	
	@Autowired
	private DataSource dataSource;
	
	private static final int BUFFER_SIZE = 4096;
	
	@RequestMapping(value="reporteGeneralPrograma",method=RequestMethod.GET)
	public String vistaGeneralPrograma(Model modelo){
	List<Programa> listado = servPrograma.listarProgramas(1, 8);
		
		modelo.addAttribute("programa", listado);
		
		System.out.println("Obteniendo el formulario");
		return "reporteGeneralPrograma";	
	}
	
		
	@RequestMapping(value="reporteHomologantes",method=RequestMethod.GET)
	public String vistaHomologantes(Model modelo){
	List<Programa> listado = servPrograma.listarProgramas(1, 8);
		
		modelo.addAttribute("programa", listado);
		
		System.out.println("Obteniendo el formulario");
		return "reporteHomologantes";
		}
	
	@RequestMapping(value="reporteEstrato",method=RequestMethod.GET)
	public String vistaEstrato(Model modelo){
			
		System.out.println("Obteniendo el formulario");
		return "reporteEstrato";
		}
	
	@RequestMapping(value="reporteGeneralEvento",method=RequestMethod.GET)
	public String vistaGeneralEvento(Model modelo){
	List<Evento> listado = servEvento.listarEvento(1, 8);
		
		modelo.addAttribute("evento", listado);
		
		System.out.println("Obteniendo el formulario");
		return "reporteGeneralEvento";	
	}
	
	@RequestMapping(value="reporteEtapaPreinscripcionEvento",method=RequestMethod.GET)
	public String vistareporteEtapaPreinscripcionEvento(Model modelo){
	List<Evento> listado = servEvento.listarEvento(1, 8);
		
		modelo.addAttribute("evento", listado);
		
		System.out.println("Obteniendo el formulario");
		return "reporteEtapaEvento";	
	}
	
	@RequestMapping(value="reporteEtapaPreinscripcionPrograma",method=RequestMethod.GET)
	public String vistareporteEtapaPrograma(Model modelo){
		List<Programa> listado = servPrograma.listarProgramas(1, 8);
		
		modelo.addAttribute("programa", listado);
		
		System.out.println("Obteniendo el formulario");
		return "reporteEtapaPrograma";	
	}
	
	@RequestMapping(value="reporteProgramasEventosInhabilitados",method=RequestMethod.GET)
	public String vistareporteProgramasEventosInhabilitados(Model modelo){
		List<Programa> listado = servPrograma.listarProgramas(1, 8);
		
		modelo.addAttribute("programa", listado);
        
		List<Evento> listado1 = servEvento.listarEvento(1, 8);
		
		modelo.addAttribute("evento", listado1);
		
		System.out.println("Obteniendo el formulario");
		return "reporteProgramasEventosInhabilitados";	
	}
	
	@RequestMapping(value="/download.do",method = RequestMethod.GET)
	// Variables para generar reportes
    public String doDownload(@RequestParam(value="pro", required= false)String pro,
    						@RequestParam(value= "fomato", required= false)String formato,
    						@RequestParam(value="reporte", required=false) String reporte,
    						@RequestParam(value="event", required=false) String event,
    						@RequestParam(value="status", required=false) String status,
    						@RequestParam(value="etapa", required=false) String etapa,
    						@RequestParam(value="procesop", required=false) String procesop,
    						@RequestParam(value="procesoe", required=false) String procesoe,
    						HttpServletRequest request,
    						HttpServletResponse response, Model modelo) throws IOException {
							ClassPathResource jasperpdf= new ClassPathResource("jasper/");
		String nombreR = "";	
		String query=null;
		if(reporte.equals("1")){
			nombreR = "reporteGeneralUsuarios";
		}if(reporte.equals("2"))
		{
			nombreR="reporteHomologaciones";
		}
		if(reporte.equals("3"))
		{
			nombreR="reporteEstrato";
		}
		if(reporte.equals("4")){
		nombreR="reporteEvento";
		}
		if(reporte.equals("5")){
			nombreR="reporteEtapaEvento";
			}
		if(reporte.equals("6")){
			nombreR="reporteEtapaPrograma";
			}
		if(reporte.equals("7")){
			nombreR="repoteProceso";
			}
		
    	try{
    		Map<String, Object> parameters = new HashMap<String, Object>();
    		//parametros de reportes 
    		  parameters.put("programa",pro);
    		  parameters.put("evento",event);
    		  parameters.put("estrato",status);
    		  System.out.println("ROLLBACK EJECUTADO"+status);
    		  parameters.put("etapa",etapa);
    		  parameters.put("procesop",procesop);
    		  parameters.put("procesoe",procesoe);
		      parameters.put("imagenucc", "Imagenes/ucc.png");
		      parameters.put("imagenlinea", "Imagenes/linea.png");
		      parameters.put("cuadros", "Imagenes/cuadros.png");
		     
		      ClassPathResource jasperXML= new ClassPathResource("jasper/"+nombreR+".jrxml");
		     
		        JasperReport report= JasperCompileManager.compileReport(jasperXML.getInputStream());
		        JasperPrint print = JasperFillManager.fillReport(report, parameters, dataSource.getConnection());
		        System.out.println("ROLLBACK EJECUTADO");
		        JasperExportManager.exportReportToPdfFile(print,jasperpdf.getFilename()+nombreR+".pdf");
		        JasperViewer.viewReport(print, false);
		        System.out.println("ROLLBACK EJECUTADO" + jasperpdf.getPath());
    	}catch (Exception e) {
		      e.printStackTrace();
		    }
    	
    	String filePath = nombreR+".pdf";
        ServletContext context = request.getServletContext();
        String appPath = jasperpdf.getFilename();
        System.out.println("appPath = " + appPath);
        String fullPath = appPath + filePath;      
        File downloadFile = new File(fullPath);
        FileInputStream inputStream = new FileInputStream(downloadFile);
        String mimeType = context.getMimeType(fullPath);
        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }
        System.out.println("MIME type: " + mimeType);
        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",downloadFile.getName());
        response.setHeader(headerKey, headerValue);
        OutputStream outStream = response.getOutputStream();
        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead = -1;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
        inputStream.close();
        outStream.close();
        return "formularioEstudiante1";
    }
}
