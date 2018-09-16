package vhcsoft.com.vhcsoft.blog.versioning.h2.trigger;

import java.sql.Connection;
import java.sql.SQLException;

import org.h2.api.Trigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VersionTrigger implements Trigger {

	private static final Logger log = LoggerFactory.getLogger(VersionTrigger.class);

	@Override
	public void init(Connection conn, String schemaName, String triggerName, String tableName, boolean before, int type)
			throws SQLException {
		log.debug("table name" + tableName);
	}

	@Override
	public void fire(Connection conn, Object[] oldRow, Object[] newRow) throws SQLException {
		Long version = (Long) newRow[4];
		version = version + 1;
		newRow[4] = version;
		log.debug("" + newRow);
	}

	@Override
	public void close() throws SQLException {
	}

	@Override
	public void remove() throws SQLException {
	}

}
