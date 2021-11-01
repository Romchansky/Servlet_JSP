package ua.goit.repository;

import ua.goit.model.BaseEntity;
import ua.goit.model.Developer;

import java.util.List;
import java.util.Map;

public interface QueryRepository<T extends BaseEntity<ID>, ID> {

    List getSalaryDevsByProject(Long id);

    List<T> listDevelopersByProject(Long id);

    List<T> listDevelopersByProgramLanguage(String language);

    List<T> listLevelDevelopers(String levelDev);

    List<T> listProWithData();

}
