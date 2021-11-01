package ua.goit.controller;

import lombok.SneakyThrows;
import ua.goit.model.Customer;
import ua.goit.repository.CrudRepository;
import ua.goit.repository.RepositoryFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(urlPatterns = "/customer/*")
public class CustomerServlet extends HttpServlet {

    private CrudRepository<Customer, Long> customerRepository;

    @Override
    public void init() {
        customerRepository = RepositoryFactory.of(Customer.class);
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String action = req.getPathInfo();
        if (action.startsWith("/find_Customer")) {
            req.getRequestDispatcher("/view/customer/find_customer.jsp").forward(req, resp);
        }

        if (action.startsWith("/create_Customer")) {
            req.getRequestDispatcher("/view/customer/create_customer.jsp").forward(req, resp);
        }

        if (action.startsWith("/update_Customer")) {
            req.getRequestDispatcher("/view/customer/update_customer.jsp").forward(req, resp);
        }

        if (action.startsWith("/delete_Customer")) {
            req.getRequestDispatcher("/view/customer/delete_customer.jsp").forward(req, resp);
        }

        if (action.startsWith("/all_Customers")) {
            List<Customer> customers = customerRepository.findAll();
            req.setAttribute("customers", customers);
            req.getRequestDispatcher("/view/customer/all_customers.jsp").forward(req, resp);
        }
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String action = req.getPathInfo();

        if (action.startsWith("/create_Customer")) {
            createCustomer(req, resp);
        }
        if (action.startsWith("/find_Customer")) {
            findCustomer(req, resp);
        }
        if (action.startsWith("/delete_Customer")) {
            deleteCustomer(req, resp);
        }
        if (action.startsWith("/update_Customer")) {
            updateCustomer(req, resp);
        }
    }

    @SneakyThrows
    private void createCustomer(HttpServletRequest req, HttpServletResponse resp) {
        Customer customer = buildCustomer(req);
        req.getRequestDispatcher("/view/customer/create_customer.jsp").forward(req, resp);
        customerRepository.create(customer);
        req.setAttribute("message", "Customer create successful: " + customer);
    }

    @SneakyThrows
    private void findCustomer(HttpServletRequest req, HttpServletResponse resp) {
        Long id = Long.valueOf(req.getParameter("id"));
        Optional<Customer> customer = customerRepository.findById(id);
        if (!customer.isPresent()) {
            req.setAttribute("message", "Request customer not found");
        } else {
            req.setAttribute("message", String.format("Customer by id is found: %s, ", customer));
        }
        req.getRequestDispatcher("/view/customer/find_customer.jsp").forward(req, resp);
    }

    @SneakyThrows
    private void deleteCustomer(HttpServletRequest req, HttpServletResponse resp){
        Long id = Long.valueOf((req.getParameter("id")));
        Optional<Customer> byIdCustomer = customerRepository.findById(id);
        if (!byIdCustomer.isPresent()) {
            req.setAttribute("message", "Request customer not found");
        } else {
            customerRepository.deleteById(id);
            req.setAttribute("message", "Delete customer successful");
        }
        req.getRequestDispatcher("/view/customer/delete_customer.jsp").forward(req, resp);
    }

    @SneakyThrows
    private void updateCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf((req.getParameter("id")));
        Optional<Customer> byIdCustomer = customerRepository.findById(id);
        if (!byIdCustomer.isPresent()) {
            req.setAttribute("message", "Customer not found");
        } else {
            String newIndustry = req.getParameter("industry");
            String newCity = req.getParameter("city");
            byIdCustomer.get().setIndustry(newIndustry);
            byIdCustomer.get().setCity(newCity);
            customerRepository.update(byIdCustomer.get());
            req.setAttribute("message", "Customer updated");
            req.getRequestDispatcher("/view/customer/update_customer.jsp").forward(req, resp);
        }
    }

    private Customer buildCustomer(HttpServletRequest request) {
        return Customer.builder()
                .id(Long.valueOf(request.getParameter("id")))
                .name(request.getParameter("name"))
                .city(request.getParameter("city"))
                .industry(request.getParameter("industry"))
                .build();
    }


}
