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
import net.rafaelaznar.bean.FamiliaBean;
import net.rafaelaznar.dao.FamiliaDao;
import net.rafaelaznar.helper.EncodingUtil;
import net.rafaelaznar.helper.OrderFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Familia {

    @Autowired
    FamiliaDao oFamiliaDAO;

    @RequestMapping({"/familia/indexlist.html"})
    public ModelAndView indexlist(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        return new ModelAndView("index", "contenido", "familia/list.jsp");
    }

    @RequestMapping({"/familia/indexform.html"})
    public ModelAndView indexform(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        return new ModelAndView("index", "contenido", "familia/form.jsp");
    }

    @RequestMapping({"/familia/list.html"})
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        return new ModelAndView("familia/list");
    }

    @RequestMapping({"/familia/form.html"})
    public ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        return new ModelAndView("familia/form");
    }

    @RequestMapping({"/familia/{id}/get.json"})
    public ModelAndView get(@PathVariable Integer id) throws UnsupportedEncodingException, ServletException {
        String data;
        try {
            FamiliaBean oFamilia = new FamiliaBean();
            oFamilia.setId(id);
            oFamiliaDAO.get(oFamilia);
            data = new Gson().toJson(oFamilia);
            return new ModelAndView("messageAjax", "contenido", data);
        } catch (Exception e) {
            throw new ServletException("FamiliaGetJson: View Error: " + e.getMessage());
        }
    }

    @RequestMapping({"/familia/{rpp}/{page}/getpage.json"})
    public ModelAndView getPage(@PathVariable Integer rpp, @PathVariable Integer page, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, ServletException {
        String data;
        try {
            List<FamiliaBean> oFamilias = oFamiliaDAO.getPage(rpp, page, OrderFilter.getFilter(request), OrderFilter.getOrder(request));
            data = new Gson().toJson(oFamilias);
            data = "{\"list\":" + data + "}";
            return new ModelAndView("messageAjax", "contenido", data);

        } catch (Exception e) {
            throw new ServletException("FamiliaGetJson: View Error: " + e.getMessage());
        }
    }

    @RequestMapping({"/familia/{rpp}/getpages.json"})
    public ModelAndView getPages(@PathVariable Integer rpp, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, ServletException {
        String data;
        try {
            int pages = oFamiliaDAO.getPages(rpp, OrderFilter.getFilter(request), OrderFilter.getOrder(request));
            data = "{\"data\":\"" + Integer.toString(pages) + "\"}";
            return new ModelAndView("messageAjax", "contenido", data);

        } catch (Exception e) {
            throw new ServletException("FamiliaGetJson: View Error: " + e.getMessage());
        }
    }

    @RequestMapping({"/familia/getprettycolumns.json"})
    public ModelAndView getPrettyColumns() throws UnsupportedEncodingException, ServletException {
        try {
            String data = "{\"data\": [\"Id.\", \"Código Familia\", \"Nombre Familia\"]}";
            return new ModelAndView("messageAjax", "contenido", data);
        } catch (Exception e) {
            throw new ServletException("FamiliaGetpagesJson: View Error: " + e.getMessage());
        }
    }

    @RequestMapping({"/familia/getcolumns.json"})
    public ModelAndView getColumns() throws UnsupportedEncodingException, ServletException {
        try {
            ArrayList<String> alColumns;
            alColumns = oFamiliaDAO.getColumnsNames();
            String data = new Gson().toJson(alColumns);
            data = "{\"data\":" + data + "}";
            return new ModelAndView("messageAjax", "contenido", data);
        } catch (Exception e) {
            throw new ServletException("FamiliaGetcolumnsJson: View Error: " + e.getMessage());
        }
    }

    @RequestMapping({"/familia/getregisters.json"})
    public ModelAndView getRegisters(HttpServletRequest request) throws UnsupportedEncodingException, ServletException, Exception {
        int pages = oFamiliaDAO.getCount(OrderFilter.getFilter(request));
        String data = "{\"data\":\"" + Integer.toString(pages) + "\"}";
        return new ModelAndView("messageAjax", "contenido", data);
    }

    @RequestMapping({"/familia/{id}/remove.json"})
    public ModelAndView getRemove(@PathVariable Integer id) throws UnsupportedEncodingException, ServletException, Exception {

        try {
            FamiliaBean oFamilia = new FamiliaBean(id);
            Map<String, String> data = new HashMap<>();
            oFamiliaDAO.remove(oFamilia);
            data.put("status", "200");
            data.put("message", "se ha eliminado el registro con id = " + oFamilia.getId());
            Gson gson = new Gson();
            String resultado = gson.toJson(data);
            return new ModelAndView("messageAjax", "contenido", resultado);
        } catch (Exception e) {
            throw new ServletException("FamiliaRemoveJson: View Error: " + e.getMessage());
        }

    }

    @RequestMapping({"/familia/save.json"})
    public ModelAndView getRemove(HttpServletRequest request) throws UnsupportedEncodingException, ServletException, Exception {
        try {
            FamiliaBean oFamilia = new FamiliaBean();
            Gson gson = new Gson();
            String jason = request.getParameter("json");
            jason = EncodingUtil.decodeURIComponent(jason);
            oFamilia = gson.fromJson(jason, oFamilia.getClass());
            Map<String, String> data = new HashMap<>();
            oFamilia = oFamiliaDAO.set(oFamilia);
            data.put("status", "200");
            data.put("message", Integer.toString(oFamilia.getId()));
            String resultado = gson.toJson(data);
            return new ModelAndView("messageAjax", "contenido", resultado);
        } catch (Exception e) {
            throw new ServletException("FamiliaSaveJson: View Error: " + e.getMessage());
        }
    }

}
