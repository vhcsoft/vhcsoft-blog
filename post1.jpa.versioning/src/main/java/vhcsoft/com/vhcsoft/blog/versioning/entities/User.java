package vhcsoft.com.vhcsoft.blog.versioning.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@Column(nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createdDate;
 
    @Column
    @LastModifiedDate
    private LocalDateTime modifiedDate;
    
    @Autowired
	@Version
    @Generated(GenerationTime.ALWAYS)
    @Type(type ="vhcsoft.com.vhcsoft.blog.versioning.entities.DBVersionType")
    private Long version;
    
}
