package com.revature.project2.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="customer")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int customer_id;
	
	private String first_name;
	private String last_name;
	private String email;
	private String phone;
	private String pass;
	private String gender;
	
	@OneToMany(mappedBy="creator", fetch=FetchType.EAGER)
	private List<Post> createdPosts = new ArrayList<>();
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name = "bookmarked_posts",
			joinColumns = {@JoinColumn(name="customer_id")},
			inverseJoinColumns = {@JoinColumn(name="post_id")}
			)
	private List<Post> bookmarkedPosts = new ArrayList<>();
	
	public User() {
		super();
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Post> getCreatedPosts() {
		return createdPosts;
	}

	public void setCreatedPosts(List<Post> createdPosts) {
		this.createdPosts = createdPosts;
	}

	public List<Post> getBookmarkedPosts() {
		return bookmarkedPosts;
	}

	public void setBookmarkedPosts(List<Post> bookmarkedPosts) {
		this.bookmarkedPosts = bookmarkedPosts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookmarkedPosts == null) ? 0 : bookmarkedPosts.hashCode());
		result = prime * result + ((createdPosts == null) ? 0 : createdPosts.hashCode());
		result = prime * result + customer_id;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (bookmarkedPosts == null) {
			if (other.bookmarkedPosts != null)
				return false;
		} else if (!bookmarkedPosts.equals(other.bookmarkedPosts))
			return false;
		if (createdPosts == null) {
			if (other.createdPosts != null)
				return false;
		} else if (!createdPosts.equals(other.createdPosts))
			return false;
		if (customer_id != other.customer_id)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [customer_id=" + customer_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", email=" + email + ", phone=" + phone + ", pass=" + pass + ", gender=" + gender + ", createdPosts="
				+ createdPosts + ", bookmarkedPosts=" + bookmarkedPosts + "]";
	}

}
