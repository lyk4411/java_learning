package DAO;

import java.io.Serializable;
import java.util.Date;


public class Task implements Serializable {

    public enum TaskStatus {

        UNKNOWN("UNKNOWN", 0),
        PREP("PREP", 1),
        RUNNING("RUNNING", 2),
        SUSPENDED("SUSPENDED", 3),
        SUCCEEDED("SUCCEEDED", 4),
        KILLED("KILLED", 5),
        FAILED("FAILED", 6);

        private String name;
        private int index;

        private TaskStatus(String name, int index) {
            this.name = name;
            this.index = index;
        }

        public String getName() {
            return this.name;
        }
        public int getIndex() {
            return this.index;
        }

        public static TaskStatus valueOf(int value) {
            switch (value) {
                case 1:
                    return PREP;
                case 2:
                    return RUNNING;
                case 3:
                    return SUSPENDED;
                case 4:
                    return SUCCEEDED;
                case 5:
                    return KILLED;
                case 6:
                    return FAILED;
                default:
                    return UNKNOWN;
            }
        }
    }

    private static final long serialVersionUID = 1L;

    private String taskid;
    private String metadata;
    private Integer status;
    private String deletion_url;
    private String retrieve_url;
    private String cache_directory;
    private Integer query_counts;
    private Date query_lasttime;
    private Date expired_time;
    private Integer is_deleted;

    public Task() {
    }

    public Task(String taskid, String metadata, Integer status,
                String deletion_url, String retrieve_url, String cache_directory,
                Integer query_counts, Date query_lasttime, Date expired_time,
                Integer is_deleted) {
        super();
        this.taskid = taskid;
        this.metadata = metadata;
        this.status = status;
        this.deletion_url = deletion_url;
        this.retrieve_url = retrieve_url;
        this.cache_directory = cache_directory;
        this.query_counts = query_counts;
        this.query_lasttime = query_lasttime;
        this.expired_time = expired_time;
        this.is_deleted = is_deleted;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }
    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public void setDeletion_url(String deletion_url) {
        this.deletion_url = deletion_url;
    }
    public void setRetrieve_url(String retrieve_url) {
        this.retrieve_url = retrieve_url;
    }
    public void setCache_directory(String cache_directory) {
        this.cache_directory = cache_directory;
    }
    public void setQuery_counts(Integer query_counts) {
        this.query_counts = query_counts;
    }
    public void setQuery_lasttime(Date query_lasttime) {
        this.query_lasttime = query_lasttime;
    }
    public void setExpired_time(Date expired_time) {
        this.expired_time = expired_time;
    }
    public void setIs_deleted(Integer is_deleted) {
        this.is_deleted = is_deleted;
    }
    public String getTaskid() {
        return taskid;
    }
    public String getMetadata() {
        return metadata;
    }
    public Integer getStatus() {
        return status;
    }
    public String getDeletion_url() {
        return deletion_url;
    }
    public String getRetrieve_url() {
        return retrieve_url;
    }
    public String getCache_directory() {
        return cache_directory;
    }
    public Integer getQuery_counts() {
        return query_counts;
    }
    public Date getQuery_lasttime() {
        return query_lasttime;
    }
    public Date getExpired_time() {
        return expired_time;
    }
    public Integer getIs_deleted() {
        return is_deleted;
    }

    @Override
    public String toString() {
        return "Ttask [taskid=" + taskid + "]";
    }

}