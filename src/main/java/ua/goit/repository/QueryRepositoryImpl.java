package ua.goit.repository;


import lombok.SneakyThrows;
import ua.goit.model.Developer;
import ua.goit.model.dto.ProjectDto;
import ua.goit.utils.DataBaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;


public class QueryRepositoryImpl implements QueryRepository {


    private final Connection connection;
    private Statement statement;

    @SneakyThrows
    public QueryRepositoryImpl() {
        this.connection = DataBaseConnection.getInstance().getConnection();
        this.statement = connection.createStatement();
    }

    @SneakyThrows
    @Override
    public List getSalaryDevsByProject(Long id) {
        String querySalary = "SELECT SUM(developers.salary) AS sumSalary FROM initDataBase.developers_projects " +
                "INNER JOIN initDataBase.developers ON initDataBase.developers_projects.id_developer = developers.id " +
                "INNER JOIN  initDataBase.projects ON initDataBase.developers_projects.id_project ='" + id + "'" +
                "GROUP BY projects.id LIMIT 1";
        ResultSet resultSet = statement.executeQuery(querySalary);
        resultSet.next();
        return Collections.singletonList(resultSet.getString("sumSalary"));
    }

    @Override
    public List<Developer> listDevelopersByProject(Long id) {
        String queryDevelopersProject = "SELECT * FROM initDataBase.developers d, initDataBase.projects p, initDataBase.developers_projects dp" +
                " WHERE  d.id=dp.id_developer AND p.id = dp.id_project AND p.id ='" + id + "'";
        return getDevelopersResult(queryDevelopersProject);
    }

    @Override
    public List<Developer> listDevelopersByProgramLanguage(String language) {
        String queryDeveloperSkill = "SELECT d.id, d.name,d.age, d.gender, d.salary FROM initDataBase.developers d " +
                " INNER JOIN initDataBase.developers_skills ds ON d.id = ds.id_developer " +
                " INNER JOIN initDataBase.skills s ON ds.id_skill = s.id" +
                " WHERE s.language ='" + language + "'";
        return getDevelopersResult(queryDeveloperSkill);
    }

    @Override
    public List<Developer> listLevelDevelopers(String levelDev) {
        String queryDeveloperLevel = "SELECT d.id, d.name,d.age, d.gender, d.salary FROM initDataBase.developers d " +
                "INNER JOIN initDataBase.developers_skills ds ON d.id = ds.id_developer " +
                "INNER JOIN initDataBase.skills s ON ds.id_skill = s.id" +
                " WHERE s.level ='" + levelDev + "'";
        return getDevelopersResult(queryDeveloperLevel);
    }

    @SneakyThrows
    @Override
    public List listProWithData() {
        List<Object> projects = new ArrayList();
        String queryData = "SELECT p.id, p.create_date, p.name, count(d.name) AS quantity FROM  initDataBase.projects p" +
                " JOIN  initDataBase.developers_projects dp ON  p.id = dp.id_project " +
                " JOIN  initDataBase.developers d ON d.id = dp.id_developer " +
                " GROUP BY  p.name ORDER BY p.create_date ";
        ResultSet resultSet = statement.executeQuery(queryData);
        while (resultSet.next()) {
            ProjectDto projectDto = ProjectDto.builder()
                    .name(resultSet.getString("name"))
                    .date(resultSet.getString("create_date"))
                    .quantityDeveloper(resultSet.getInt("quantity"))
                    .build();
            projects.add(projectDto);
        }
        return projects;
    }

    @SneakyThrows
    private List<Developer> getDevelopersResult(String query) {
        List<Developer> developers = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            Developer developer = Developer.builder()
                    .id(resultSet.getLong("id"))
                    .name(resultSet.getString("name"))
                    .age(resultSet.getInt("age"))
                    .gender(resultSet.getString("gender"))
                    .salary(resultSet.getLong("salary"))
                    .build();
            developers.add(developer);
        }
        return developers;
    }
}

