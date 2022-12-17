package com.enexse.agentproject.entity;




import javax.persistence.*;

@Entity
@Table(name = "agents")
public class Agent {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "os")
    private String os;

    @Column(name = "ip")
    private String ip;

    @Column(name = "last_Keep_Alive")
    private String lastKeepAlive;

    @Column(name = "date_Add")
    private String dateAdd;

    @Column(name = "name")
    private String name;

    @Column(name = "version")
    private String version;

    @Column(name = "status")
    private Status status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLastKeepAlive() {
        return lastKeepAlive;
    }

    public void setLastKeepAlive(String lastKeepAlive) {
        this.lastKeepAlive = lastKeepAlive;
    }

    public String getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(String dateAdd) {
        this.dateAdd = dateAdd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "id=" + id +
                ", os='" + os + '\'' +
                ", ip='" + ip + '\'' +
                ", lastKeepAlive=" + lastKeepAlive +
                ", dateAdd=" + dateAdd +
                ", name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", status=" + status +
                '}';
    }
}
