/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.rafaelaznar.control;

import com.google.gson.Gson;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.rafaelaznar.bean.AlumnoBean;
import net.rafaelaznar.dao.AlumnoDao;
import net.rafaelaznar.helper.EncodingUtil;
import net.rafaelaznar.helper.OrderFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Alumno {

    @Autowired
    AlumnoDao oAlumnoDAO;

    @RequestMapping({"/alumno/indexlist.html"})
    public ModelAndView indexlist(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        return new ModelAndView("index", "contenido", "alumno/list.jsp");
    }

    @RequestMapping({"/alumno/indexform.html"})
    public ModelAndView indexform(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        return new ModelAndView("index", "contenido", "alumno/form.jsp");
    }

    @RequestMapping({"/alumno/list.html"})
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        return new ModelAndView("alumno/list");
    }

    @RequestMapping({"/alumno/form.html"})
    public ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        return new ModelAndView("alumno/form");
    }

    @RequestMapping({"/alumno/{id}/get.json"})
    public ModelAndView get(@PathVariable Integer id) throws UnsupportedEncodingException, ServletException {
        String data;
        try {
            AlumnoBean oAlumno = new AlumnoBean();
            oAlumno.setId(id);
            oAlumnoDAO.get(oAlumno);
            data = new Gson().toJson(oAlumno);
            return new ModelAndView("messageAjax", "contenido", data);
        } catch (Exception e) {
            throw new ServletException("AlumnoGetJson: View Error: " + e.getMessage());
        }
    }

    @RequestMapping({"/alumno/{rpp}/{page}/getpage.json"})
    public ModelAndView getPage(@PathVariable Integer rpp, @PathVariable Integer page, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, ServletException {
        String data;
        try {
            List<AlumnoBean> oAlumnos = oAlumnoDAO.getPage(rpp, page, OrderFilter.getFilter(request), OrderFilter.getOrder(request));
            data = new Gson().toJson(oAlumnos);
            data = "{\"list\":" + data + "}";
            return new ModelAndView("messageAjax", "contenido", data);

        } catch (Exception e) {
            throw new ServletException("AlumnoGetJson: View Error: " + e.getMessage());
        }
    }

    @RequestMapping({"/alumno/{rpp}/getpages.json"})
    public ModelAndView getPages(@PathVariable Integer rpp, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, ServletException {
        String data;
        try {
            int pages = oAlumnoDAO.getPages(rpp, OrderFilter.getFilter(request), OrderFilter.getOrder(request));
            data = "{\"data\":\"" + Integer.toString(pages) + "\"}";
            return new ModelAndView("messageAjax", "contenido", data);

        } catch (Exception e) {
            throw new ServletException("AlumnoGetJson: View Error: " + e.getMessage());
        }
    }

    @RequestMapping({"/alumno/getprettycolumns.json"})
    public ModelAndView getPrettyColumns() throws UnsupportedEncodingException, ServletException {
        try {
            String data = "{\"data\": [\"Id\", \"Alumno\"]}";
            return new ModelAndView("messageAjax", "contenido", data);
        } catch (Exception e) {
            throw new ServletException("AlumnoGetpagesJson: View Error: " + e.getMessage());
        }
    }

    @RequestMapping({"/alumno/getcolumns.json"})
    public ModelAndView getColumns() throws UnsupportedEncodingException, ServletException {
        try {
            ArrayList<String> alColumns;
            alColumns = oAlumnoDAO.getColumnsNames();
            String data = new Gson().toJson(alColumns);
            data = "{\"data\":" + data + "}";
            return new ModelAndView("messageAjax", "contenido", data);
        } catch (Exception e) {
            throw new ServletException("AlumnoGetcolumnsJson: View Error: " + e.getMessage());
        }
    }

    @RequestMapping({"/alumno/getregisters.json"})
    public ModelAndView getRegisters(HttpServletRequest request) throws UnsupportedEncodingException, ServletException, Exception {
        int pages = oAlumnoDAO.getCount(OrderFilter.getFilter(request));
        String data = "{\"data\":\"" + Integer.toString(pages) + "\"}";
        return new ModelAndView("messageAjax", "contenido", data);
    }

    @RequestMapping({"/alumno/{id}/remove.json"})
    public ModelAndView getRemove(@PathVariable Integer id) throws UnsupportedEncodingException, ServletException, Exception {

        try {
            AlumnoBean oAlumno = new AlumnoBean(id);
            Map<String, String> data = new HashMap<>();
            oAlumnoDAO.remove(oAlumno);
            data.put("status", "200");
            data.put("message", "se ha eliminado el registro con id = " + oAlumno.getId());
            Gson gson = new Gson();
            String resultado = gson.toJson(data);
            return new ModelAndView("messageAjax", "contenido", resultado);
        } catch (Exception e) {
            throw new ServletException("AlumnoRemoveJson: View Error: " + e.getMessage());
        }

    }

    @RequestMapping({"/alumno/save.json"})
    public ModelAndView getSave(HttpServletRequest request) throws UnsupportedEncodingException, ServletException, Exception {
        try {
            AlumnoBean oAlumno = new AlumnoBean();
            Gson gson = new Gson();
            String jason = request.getParameter("json");
            jason = EncodingUtil.decodeURIComponent(jason);
            oAlumno = gson.fromJson(jason, oAlumno.getClass());
            Map<String, String> data = new HashMap<>();
            oAlumno = oAlumnoDAO.set(oAlumno);
            data.put("status", "200");
            data.put("message", Integer.toString(oAlumno.getId()));
            String resultado = gson.toJson(data);
            return new ModelAndView("messageAjax", "contenido", resultado);
        } catch (Exception e) {
            throw new ServletException("AlumnoSaveJson: View Error: " + e.getMessage());
        }
    }

}
