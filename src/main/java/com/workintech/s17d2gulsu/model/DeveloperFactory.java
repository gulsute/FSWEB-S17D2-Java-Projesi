package com.workintech.s17d2gulsu.model;

import com.workintech.s17d2gulsu.tax.Taxable;

public class DeveloperFactory {
    public static Developer createDeveloper(Developer developer, Taxable taxable) {
        Developer savedDev = null;
        if (developer.getExperience().name().equalsIgnoreCase("junior")) {
            savedDev = new JrDeveloper(developer.getId(), developer.getName(),
                    developer.getSalary() - (developer.getSalary() * taxable.getSimpleTaxRate()));

        } else if (developer.getExperience().name().equalsIgnoreCase("mid")) {
            savedDev = new MidDeveloper(developer.getId(), developer.getName(),
                    developer.getSalary() - (developer.getSalary() * taxable.getMiddleTaxRate()));

        } else if (developer.getExperience().name().equalsIgnoreCase("senior")) {
            savedDev = new SrDeveloper(developer.getId(), developer.getName(),
                    developer.getSalary() - (developer.getSalary() * taxable.getUpperTaxRate()));
        }
        return savedDev;
    }}