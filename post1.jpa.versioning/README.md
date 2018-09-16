# VHCSoft consulting company

## Database generated version
In our last project we faced the following problem.
Our application uses existing database table. The table has a version column and a trigger, which creates new version for updated data row.
We uses Hibernate and AuditingEntityListener of spring boot to generate audit informations (updatedDate, updatedUser, etc).
In our `User` entity the following configuration are done. 

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
	    //@Type(type ="vhcsoft.com.vhcsoft.blog.versioning.entities.DBVersionType")
	    private Long version;
	    
	}
	
