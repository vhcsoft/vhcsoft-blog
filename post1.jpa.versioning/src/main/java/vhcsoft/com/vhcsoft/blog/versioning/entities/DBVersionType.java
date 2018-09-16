package vhcsoft.com.vhcsoft.blog.versioning.entities;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.type.LongType;

public class DBVersionType extends LongType{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public Long next(Long current, SharedSessionContractImplementor session) {
		return current;
	}

}
