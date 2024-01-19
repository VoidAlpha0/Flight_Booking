package com.Airbus.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Airbus.Dao.AdminDao;
import com.Airbus.entity.Admin;

@Service
public class AdminService {
	
	@Autowired
	AdminDao admindao;
	
	public Admin addAdmin(Admin a) {
		return admindao.save(a);
	}
	
	public List<Admin> listAdmins(){
		return admindao.findAll();
	}
	
	public Admin showAdminUsingLogin(String email,String password) {
		return admindao.findByAdminemailAndAdminpassword(email, password);
	}
	
	public Admin updateAdminByEmail(String email,Admin admin) {
		Admin add = admindao.findByAdminemail(email);
		if(add!=null) {
			add.setAdminemail(admin.getAdminemail());
			add.setAdminname(admin.getAdminname());
			add.setAdminpassword(admin.getAdminpassword());
			return admindao.save(add);
		}else {
			return null;
		}
	}
	public void deleteAdmin(Integer id) {
		admindao.deleteById(id);
	}
}
