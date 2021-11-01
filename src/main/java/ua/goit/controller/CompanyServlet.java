package ua.goit.controller;


import lombok.SneakyThrows;
import ua.goit.model.Company;
import ua.goit.repository.CrudRepository;
import ua.goit.repository.RepositoryFactory;



import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;


@WebServlet(urlPatterns = "/company/*")
public class CompanyServlet extends HttpServlet {

    private CrudRepository<Company, Long> companyRepository;

    @Override
    public void init() {
        companyRepository = RepositoryFactory.of(Company.class);
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String action = req.getPathInfo();

        if (action.startsWith("/find_Company")) {
            req.getRequestDispatcher("/view/company/find_company.jsp").forward(req, resp);
        }

        if (action.startsWith("/create_Company")) {
            req.getRequestDispatcher("/view/company/create_company.jsp").forward(req, resp);
        }

        if (action.startsWith("/delete_Company")) {
            req.getRequestDispatcher("/view/company/delete_company.jsp").forward(req, resp);
        }

        if (action.startsWith("/update_Company")) {
            req.getRequestDispatcher("/view/company/update_company.jsp").forward(req, resp);
        }

        if (action.startsWith("/all_Company")) {
            List<Company> companies = companyRepository.findAll();
            req.setAttribute("companies", companies);
            req.getRequestDispatcher("/view/company/all_company.jsp").forward(req, resp);
        }
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String action = req.getPathInfo();

        if (action.startsWith("/create_Company")) {
            createCompany(req, resp);
        }

        if (action.startsWith("/find_Company")) {
            findCompany(req, resp);
        }

        if (action.startsWith("/delete_Company")) {
            deleteCompany(req, resp);
        }

        if (action.startsWith("/update_Company")) {
            updateCompany(req, resp);
        }
    }

    @SneakyThrows
    private void createCompany(HttpServletRequest req, HttpServletResponse resp) {
        Company company = buildCompany(req);
        req.getRequestDispatcher("/view/company/create_company.jsp").forward(req, resp);
        companyRepository.create(company);
        req.setAttribute("message", "Company create successful");
    }

    @SneakyThrows
    private void findCompany(HttpServletRequest req, HttpServletResponse resp) {
        Long id = Long.valueOf(req.getParameter("id"));
        Optional<Company> companyById = companyRepository.findById(id);
        if (!companyById.isPresent()) {
            req.setAttribute("message", "Request company not found");
            req.getRequestDispatcher("/view/company/find_company.jsp").forward(req, resp);
        } else {
            req.setAttribute("message", String.format("Company by id is found: %s", companyById));
            req.getRequestDispatcher("/view/company/find_company.jsp").forward(req, resp);
        }
    }

    @SneakyThrows
    private void deleteCompany(HttpServletRequest req, HttpServletResponse resp) {
        Long id = Long.valueOf(req.getParameter("id"));
        Optional<Company> byIdCompany = companyRepository.findById(id);
        if (!byIdCompany.isPresent()) {
            req.setAttribute("message", "Request company not found");
        } else {
            companyRepository.deleteById(id);
            req.setAttribute("message", "Delete company successful");
        }
        req.getRequestDispatcher("/view/company/delete_company.jsp").forward(req, resp);
    }

    @SneakyThrows
    private void updateCompany(HttpServletRequest req, HttpServletResponse resp) {
        Long id = Long.valueOf(req.getParameter("id"));
        Optional<Company> byIdCompany = companyRepository.findById(id);
        String city = req.getParameter("city");
        byIdCompany.get().setCity(city);
        companyRepository.update(byIdCompany.get());
        req.setAttribute("message", "Company updated");
        req.getRequestDispatcher("/view/company/update_company.jsp").forward(req, resp);
    }

    private Company buildCompany(HttpServletRequest request) {
//        return Company.builder()
//                .id(Long.valueOf(request.getParameter("id")))
//                .name(request.getParameter("name"))
//                .city(request.getParameter("city"))
//                .build();

        final Long companyId = Long.valueOf (request.getParameter ("id"));
        final String companyName = request.getParameter ("name");
        final String companyCity = request.getParameter ("city");
        return new Company (companyId, companyName, companyCity);
    }
}
