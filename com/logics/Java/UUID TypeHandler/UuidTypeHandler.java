import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;





import java.util.UUID;

public  class UuidTypeHandler extends BaseTypeHandler<UUID> {
	
/**
	 * Type handler for UUID type.
     * This is necessary because JDBC does not support the UUID type.
     * Fortunately, the handling of the PostgreSQL UUID and Java UUID types
     * is transparent in JDBC (using type OTHER). 
     * For background, see: {@link http://crafted-software.blogspot.com/2013/03/uuid-values-from-jdbc-to-postgres.html}.
	 *
	 * @author Srinivas Dabikar
	 * @version 1.1
 */
	 	
	
	
	    
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, UUID parameter, JdbcType jdbcType) throws SQLException {
		// TODO Auto-generated method stub
	   if (parameter == null) {
            ps.setObject(i, null, Types.OTHER);
        } else {
            ps.setObject(i, parameter, Types.OTHER);
        }
		
	}
	
	@Override
	public UUID getNullableResult(ResultSet rs, String columnName) throws SQLException {
		// TODO Auto-generated method stub
		
		return (UUID)rs.getObject(columnName);
	
	}
	
 
	@Override
	public UUID getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		
		return (UUID)rs.getObject(columnIndex);
       
	}
	
	
	@Override
	public UUID getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		
	    return (UUID)cs.getObject(columnIndex);
	}
     
   
}
    
