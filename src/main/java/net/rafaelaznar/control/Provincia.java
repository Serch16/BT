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
import net.rafaelaznar.bean.ProvinciaBean;
import net.rafaelaznar.dao.ProvinciaDao;
import net.rafaelaznar.helper.EncodingUtil;
import net.rafaelaznar.helper.OrderFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Provincia {

    @Autowired
    ProvinciaDao oProvinciaDAO;

    @RequestMapping({"/provincia/indexlist.html"})
    public ModelAndView indexlist(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        return new ModelAndView("index", "contenido", "provincia/list.jsp");
    }

    @RequestMapping({"/provincia/indexform.html"})
    public ModelAndView indexform(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        return new ModelAndView("index", "contenido", "provincia/form.jsp");
    }

    @RequestMapping({"/provincia/list.html"})
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        return new ModelAndView("provincia/list");
    }

    @RequestMapping({"/provincia/form.html"})
    public ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        return new ModelAndView("provincia/form");
    }

    @RequestMapping({"/provincia/{id}/get.json"})
    public ModelAndView get(@PathVariable Integer id) throws UnsupportedEncodingException, ServletException {
        String data;
        try {
            ProvinciaBean oProvincia = new ProvinciaBean();
            oProvincia.setId(id);
            oProvinciaDAO.get(oProvincia);
            data = new Gson().toJson(oProvincia);
            return new ModelAndView("messageAjax", "contenido", data);
        } catch (Exception e) {
            throw new ServletException("ProvinciaGetJson: View Error: " + e.getMessage());
        }
    }

    @RequestMapping({"/provincia/{rpp}/{page}/getpage.json"})
    public ModelAndView getPage(@PathVariable Integer rpp, @PathVariable Integer page, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, ServletException {
        String data;
        try {
            List<ProvinciaBean> oProvincias = oProvinciaDAO.getPage(rpp, page, OrderFilter.getFilter(request), OrderFilter.getOrder(request));
            data = new Gson().toJson(oProvincias);
            data = "{\"list\":" + data + "}";
            return new ModelAndView("messageAjax", "contenido", data);

        } catch (Exception e) {
            throw new ServletException("ProvinciaGetJson: View Error: " + e.getMessage());
        }
    }

    @RequestMapping({"/provincia/{rpp}/getpages.json"})
    public ModelAndView getPages(@PathVariable Integer rpp, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, ServletException {
        String data;
        try {
            int pages = oProvinciaDAO.getPages(rpp, OrderFilter.getFilter(request), OrderFilter.getOrder(request));
            data = "{\"data\":\"" + Integer.toString(pages) + "\"}";
            return new ModelAndView("messageAjax", "contenido", data);

        } catch (Exception e) {
            throw new ServletException("ProvinciaGetJson: View Error: " + e.getMessage());
        }
    }

    @RequestMapping({"/provincia/getprettycolumns.json"})
    public ModelAndView getPrettyColumns() throws UnsupportedEncodingException, ServletException {
        try {
            String data = "{\"data\": [\"Id\", \"Provincia\"]}";
            return new ModelAndView("messageAjax", "contenido", data);
        } catch (Exception e) {
            throw new ServletException("ProvinciaGetpagesJson: View Error: " + e.getMessage());
        }
    }

    @RequestMapping({"/provincia/getcolumns.json"})
    public ModelAndView getColumns() throws UnsupportedEncodingException, ServletException {
        try {
            ArrayList<String> alColumns;
            alColumns = oProvinciaDAO.getColumnsNames();
            String data = new Gson().toJson(alColumns);
            data = "{\"data\":" + data + "}";
            return new ModelAndView("messageAjax", "contenido", data);
        } catch (Exception e) {
            throw new ServletException("ProvinciaGetcolumnsJson: View Error: " + e.getMessage());
        }
    }

    @RequestMapping({"/provincia/getregisters.json"})
    public ModelAndView getRegisters(HttpServletRequest request) throws UnsupportedEncodingException, ServletException, Exception {
        int pages = oProvinciaDAO.getCount(OrderFilter.getFilter(request));
        String data = "{\"data\":\"" + Integer.toString(pages) + "\"}";
        return new ModelAndView("messageAjax", "contenido", data);
    }

    @RequestMapping({"/provincia/{id}/remove.json"})
    public ModelAndView getRemove(@PathVariable Integer id) throws UnsupportedEncodingException, ServletException, Exception {

        try {
            ProvinciaBean oProvincia = new ProvinciaBean(id);
            Map<String, String> data = new HashMap<>();
            oProvinciaDAO.remove(oProvincia);
            data.put("status", "200");
            data.put("message", "se ha eliminado el registro con id = " + oProvincia.getId());
            Gson gson = new Gson();
            String resultado = gson.toJson(data);
            return new ModelAndView("messageAjax", "contenido", resultado);
        } catch (Exception e) {
            throw new ServletException("ProvinciaRemoveJson: View Error: " + e.getMessage());
        }

    }

    @RequestMapping({"/provincia/save.json"})
    public ModelAndView getSave(HttpServletRequest request) throws UnsupportedEncodingException, ServletException, Exception {
        try {
            ProvinciaBean oProvincia = new ProvinciaBean();
            Gson gson = new Gson();
            String jason = request.getParameter("json");
            jason = EncodingUtil.decodeURIComponent(jason);
            oProvincia = gson.fromJson(jason, oProvincia.getClass());
            Map<String, String> data = new HashMap<>();
            oProvincia = oProvinciaDAO.set(oProvincia);
            data.put("status", "200");
            data.put("message", Integer.toString(oProvincia.getId()));
            String resultado = gson.toJson(data);
            return new ModelAndView("messageAjax", "contenido", resultado);
        } catch (Exception e) {
            throw new ServletException("ProvinciaSaveJson: View Error: " + e.getMessage());
        }
    }

}
