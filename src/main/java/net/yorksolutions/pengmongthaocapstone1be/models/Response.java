package net.yorksolutions.pengmongthaocapstone1be.models;

import javax.persistence.*;

@Entity
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String response;
    private int responseOrder;

    public Response(String response, int responseOrder) {
        this.response = response;
        this.responseOrder = responseOrder;
    }

    public Response() {
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public int getResponseOrder() {
        return responseOrder;
    }

    public void setResponseOrder(int order) {
        this.responseOrder = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
