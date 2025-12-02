package com.example.spring_jpa_demo.mapping;

public class ProjectAndTaskCount {
    private Long id;
    private String name;
    private Long count;

    public ProjectAndTaskCount(Long id, String name, Long count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getCount() {
        return count;
    }
}
