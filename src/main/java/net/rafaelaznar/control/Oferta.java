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
import net.rafaelaznar.bean.OfertaBean;
import net.rafaelaznar.dao.OfertaDao;
import net.rafaelaznar.helper.EncodingUtil;
import net.rafaelaznar.helper.OrderFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Oferta {

    @Autowired
    OfertaDao oOfertaDAO;

    @RequestMapping({"/oferta/indexlist.html"})
    public ModelAndView indexlist(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        return new ModelAndView("index", "contenido", "oferta/list.jsp");
    }

    @RequestMapping({"/oferta/indexform.html"})
    public ModelAndView indexform(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        return new ModelAndView("index", "contenido", "oferta/form.jsp");
    }

    @RequestMapping({"/oferta/list.html"})
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        return new ModelAndView("oferta/list");
    }

    @RequestMapping({"/oferta/form.html"})
    public ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        return new ModelAndView("oferta/form");
    }

    @RequestMapping({"/oferta/{id}/get.json"})
    public ModelAndView get(@PathVariable Integer id) throws UnsupportedEncodingException, ServletException {
        String data;
        try {
            OfertaBean oOferta = new OfertaBean();
            oOferta.setId(id);
            oOfertaDAO.get(oOferta);
            data = new Gson().toJson(oOferta);
            return new ModelAndView("messageAjax", "contenido", data);
        } catch (Exception e) {
            throw new ServletException("OfertaGetJson: View Error: " + e.getMessage());
        }
    }

    @RequestMapping({"/oferta/{rpp}/{page}/getpage.json"})
    public ModelAndView getPage(@PathVariable Integer rpp, @PathVariable Integer page, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, ServletException {
        String data;
        try {
            List<OfertaBean> oOfertas = oOfertaDAO.getPage(rpp, page, OrderFilter.getFilter(request), OrderFilter.getOrder(request));
            data = new Gson().toJson(oOfertas);
            data = "{\"list\":" + data + "}";
            return new ModelAndView("messageAjax", "contenido", data);

        } catch (Exception e) {
            throw new ServletException("OfertaGetJson: View Error: " + e.getMessage());
        }
    }

    @RequestMapping({"/oferta/{rpp}/getpages.json"})
    public ModelAndView getPages(@PathVariable Integer rpp, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, ServletException {
        String data;
        try {
            int pages = oOfertaDAO.getPages(rpp, OrderFilter.getFilter(request), OrderFilter.getOrder(request));
            data = "{\"data\":\"" + Integer.toString(pages) + "\"}";
            return new ModelAndView("messageAjax", "contenido", data);

        } catch (Exception e) {
            throw new ServletException("OfertaGetJson: View Error: " + e.getMessage());
        }
    }

    @RequestMapping({"/oferta/getprettycolumns.json"})
    public ModelAndView getPrettyColumns() throws UnsupportedEncodingException, ServletException {
        try {
            String data = "{\"data\": [\"Id.\", \"Referencia\", \"Categoria\", \"Descripción\", \"Requisitos\"]}";
            return new ModelAndView("messageAjax", "contenido", data);
        } catch (Exception e) {
            throw new ServletException("OfertaGetpagesJson: View Error: " + e.getMessage());
        }
    }

    @RequestMapping({"/oferta/getcolumns.json"})
    public ModelAndView getColumns() throws UnsupportedEncodingException, ServletException {
        try {
            ArrayList<String> alColumns;
            alColumns = oOfertaDAO.getColumnsNames();
            String data = new Gson().toJson(alColumns);
            data = "{\"data\":" + data + "}";
            return new ModelAndView("messageAjax", "contenido", data);
        } catch (Exception e) {
            throw new ServletException("OfertaGetcolumnsJson: View Error: " + e.getMessage());
        }
    }

    @RequestMapping({"/oferta/getregisters.json"})
    public ModelAndView getRegisters(HttpServletRequest request) throws UnsupportedEncodingException, ServletException, Exception {
        int pages = oOfertaDAO.getCount(OrderFilter.getFilter(request));
        String data = "{\"data\":\"" + Integer.toString(pages) + "\"}";
        return new ModelAndView("messageAjax", "contenido", data);
    }

    @RequestMapping({"/oferta/{id}/remove.json"})
    public ModelAndView getRemove(@PathVariable Integer id) throws UnsupportedEncodingException, ServletException, Exception {

        try {
            OfertaBean oOferta = new OfertaBean(id);
            Map<String, String> data = new HashMap<>();
            oOfertaDAO.remove(oOferta);
            data.put("status", "200");
            data.put("message", "se ha eliminado el registro con id = " + oOferta.getId());
            Gson gson = new Gson();
            String resultado = gson.toJson(data);
            return new ModelAndView("messageAjax", "contenido", resultado);
        } catch (Exception e) {
            throw new ServletException("OfertaRemoveJson: View Error: " + e.getMessage());
        }

    }

    @RequestMapping({"/oferta/save.json"})
    public ModelAndView getRemove(HttpServletRequest request) throws UnsupportedEncodingException, ServletException, Exception {
        try {
            OfertaBean oOferta = new OfertaBean();
            Gson gson = new Gson();
            String jason = request.getParameter("json");
            jason = EncodingUtil.decodeURIComponent(jason);
            oOferta = gson.fromJson(jason, oOferta.getClass());
            Map<String, String> data = new HashMap<>();
            oOferta = oOfertaDAO.set(oOferta);
            data.put("status", "200");
            data.put("message", Integer.toString(oOferta.getId()));
            String resultado = gson.toJson(data);
            return new ModelAndView("messageAjax", "contenido", resultado);
        } catch (Exception e) {
            throw new ServletException("OfertaSaveJson: View Error: " + e.getMessage());
        }
    }

}
