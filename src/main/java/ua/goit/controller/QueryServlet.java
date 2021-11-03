package ua.goit.controller;

import lombok.SneakyThrows;
import ua.goit.model.Developer;

import ua.goit.repository.QueryRepositoryImpl;



import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(urlPatterns = "/query/*")
public class QueryServlet extends HttpServlet {

    private QueryRepositoryImpl queryRepository;

    @Override
    public void init() {
        queryRepository = new QueryRepositoryImpl();
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String action = req.getPathInfo();
        if (action.startsWith("/getDeveloperByProject")) {
            req.getRequestDispatcher("/view/query/get_developers_by_project.jsp").forward(req, resp);
        }
        if (action.startsWith("/getLanguage")) {
            req.getRequestDispatcher("/view/query/get_language.jsp").forward(req, resp);
        }
        if (action.startsWith("/getLevel")) {
            req.getRequestDispatcher("/view/query/get_level.jsp").forward(req, resp);
        }
        if (action.startsWith("/getSalary")) {
            req.getRequestDispatcher("/view/query/get_salary.jsp").forward(req, resp);
        }
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String action = req.getPathInfo();
        if (action.startsWith("/getDeveloperByProject")) {
            getDevelopersByProject(req, resp);
        }

        if (action.startsWith("/getLevel")) {
            getLevel(req, resp);
        }

        if (action.startsWith("/getLanguage")) {
            getLanguage(req, resp);
        }
        if (action.startsWith("/getSalary")) {
            getSalary(req, resp);
        }
    }

    @SneakyThrows
    private void getDevelopersByProject(HttpServletRequest req, HttpServletResponse resp) {
        Long id = Long.valueOf(req.getParameter("id"));
        List<Developer> byProject = queryRepository.listDevelopersByProject(id);
        req.setAttribute("message", byProject);
        req.getRequestDispatcher("/view/query/get_developers_by_project.jsp").forward(req, resp);
    }

    @SneakyThrows
    private void getLevel(HttpServletRequest req, HttpServletResponse resp) {
        String level = req.getParameter("level");
        List<Developer> byLevel = queryRepository.listLevelDevelopers(level);
        req.setAttribute("message", byLevel);
        req.getRequestDispatcher("/view/query/get_level.jsp").forward(req, resp);
    }

    @SneakyThrows
    private void getLanguage(HttpServletRequest req, HttpServletResponse resp) {
        String skill = req.getParameter("language");
        List<Developer> bySkill = queryRepository.listDevelopersByProgramLanguage(skill);
        req.setAttribute("message", bySkill);
        req.getRequestDispatcher("/view/query/get_language.jsp").forward(req, resp);
    }

    @SneakyThrows
    private void getSalary(HttpServletRequest req, HttpServletResponse resp) {
        Long id = Long.valueOf(req.getParameter("id"));
        List salary = queryRepository.getSalaryDevsByProject(id);
        req.setAttribute("message", salary);
        req.getRequestDispatcher("/view/query/get_salary.jsp").forward(req, resp);
    }
}
