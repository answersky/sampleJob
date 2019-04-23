package com;

/**
 * created by liufeng
 * 2018/8/9
 */
public class Log {
    @Mylog(fileName = "主键id")
    private Integer id;
    @Mylog(fileName = "name")
    private String name;
    @Mylog(fileName = "日志记录时间")
    private String time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
