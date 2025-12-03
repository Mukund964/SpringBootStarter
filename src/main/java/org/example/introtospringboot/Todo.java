package org.example.introtospringboot;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
@Entity
@Getter
@Setter
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private boolean completed;
	private String title;
	private int userId;


    public Todo(){};

    Todo(int id, boolean completed, String title, int userId) {
        this.id = id;
        this.completed = completed;
        this.title = title;
        this.userId = userId;

    }



    public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setCompleted(boolean completed){
		this.completed = completed;
	}

	public boolean isCompleted(){
		return completed;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setUserId(int userId){
		this.userId = userId;
	}

	public int getUserId(){
		return userId;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"id = '" + id + '\'' + 
			",completed = '" + completed + '\'' + 
			",title = '" + title + '\'' + 
			",userId = '" + userId + '\'' + 
			"}";
		}
}
