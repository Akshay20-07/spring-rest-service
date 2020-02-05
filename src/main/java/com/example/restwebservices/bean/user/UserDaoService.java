package com.example.restwebservices.bean.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> userList= new ArrayList<User>();
	
	private static int count=3;
	static{
		userList.add(new User("adam",1,new Date()));
		userList.add(new User("bam",2,new Date()));
		userList.add(new User("dam",3,new Date()));
	}

	public List<User> findAll(){
		return userList;
	}
	
	public User save(User user){
		if(user.getId()==null){
			user.setId(++count);
		}
		userList.add(user);
		return user;
	}
	
	public User findOne(int id){
		for(User user:userList){
			if(user.getId()==id){
				return user;
			}
		}
		return null;		
	}
	
	public boolean remove(int id){
		Iterator<User> itr=userList.iterator();
		while(itr.hasNext()){
			User user=itr.next();
			if(user.getId()==id){
				itr.remove();
				return true;
			}
		}
		return false;		
	}
	
	
}
