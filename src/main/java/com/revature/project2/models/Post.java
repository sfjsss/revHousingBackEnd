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
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Post implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int post_id;
	
	private String title;
	private String rent;
	private String address;	
	private String zipcode;
	private String description;
	private String image_link_one;
	private String image_link_two;
	private String image_link_three;
	
	@ManyToOne
	@JoinColumn(name="creator_id")
	private User creator;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name="interested_posts",
			joinColumns= {@JoinColumn(name="post_id")},
			inverseJoinColumns= {@JoinColumn(name="customer_id")}
			)
	private List<User> interestedCustomers = new ArrayList<>();
	
	public Post() {
		super();
	}
	
	

	public Post(String title, String rent, String address, String zipcode, String description,
			String image_link_one, String image_link_two, String image_link_three) {
		super();
		this.title = title;
		this.rent = rent;
		this.address = address;
		this.zipcode = zipcode;
		this.description = description;
		this.image_link_one = image_link_one;
		this.image_link_two = image_link_two;
		this.image_link_three = image_link_three;
	}



	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRent() {
		return rent;
	}

	public void setRent(String rent) {
		this.rent = rent;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage_link_one() {
		return image_link_one;
	}

	public void setImage_link_one(String image_link_one) {
		this.image_link_one = image_link_one;
	}

	public String getImage_link_two() {
		return image_link_two;
	}

	public void setImage_link_two(String image_link_two) {
		this.image_link_two = image_link_two;
	}

	public String getImage_link_three() {
		return image_link_three;
	}

	public void setImage_link_three(String image_link_three) {
		this.image_link_three = image_link_three;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public List<User> getInterestedCustomers() {
		return interestedCustomers;
	}

	public void setInterestedCustomers(List<User> interestedCustomers) {
		this.interestedCustomers = interestedCustomers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((creator == null) ? 0 : creator.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((image_link_one == null) ? 0 : image_link_one.hashCode());
		result = prime * result + ((image_link_three == null) ? 0 : image_link_three.hashCode());
		result = prime * result + ((image_link_two == null) ? 0 : image_link_two.hashCode());
		result = prime * result + ((interestedCustomers == null) ? 0 : interestedCustomers.hashCode());
		result = prime * result + post_id;
		result = prime * result + ((rent == null) ? 0 : rent.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((zipcode == null) ? 0 : zipcode.hashCode());
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
		Post other = (Post) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (creator == null) {
			if (other.creator != null)
				return false;
		} else if (!creator.equals(other.creator))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (image_link_one == null) {
			if (other.image_link_one != null)
				return false;
		} else if (!image_link_one.equals(other.image_link_one))
			return false;
		if (image_link_three == null) {
			if (other.image_link_three != null)
				return false;
		} else if (!image_link_three.equals(other.image_link_three))
			return false;
		if (image_link_two == null) {
			if (other.image_link_two != null)
				return false;
		} else if (!image_link_two.equals(other.image_link_two))
			return false;
		if (interestedCustomers == null) {
			if (other.interestedCustomers != null)
				return false;
		} else if (!interestedCustomers.equals(other.interestedCustomers))
			return false;
		if (post_id != other.post_id)
			return false;
		if (rent == null) {
			if (other.rent != null)
				return false;
		} else if (!rent.equals(other.rent))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (zipcode == null) {
			if (other.zipcode != null)
				return false;
		} else if (!zipcode.equals(other.zipcode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Post [post_id=" + post_id + ", title=" + title + ", rent=" + rent + ", address=" + address
				+ ", zipcode=" + zipcode + ", description=" + description + ", image_link_one=" + image_link_one
				+ ", image_link_two=" + image_link_two + ", image_link_three=" + image_link_three + ", creator="
				+ creator + ", interestedCustomers=" + interestedCustomers + "]";
	}

}
