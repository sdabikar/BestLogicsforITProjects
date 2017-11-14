import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public class EnumTypeHandler<G extends Enum<G>> extends BaseTypeHandler<G> {

    /**Type handler for Enum data type
	 * This is neccessary for the for creating the enum data type in the postgresql 
	 * 
	 * @author Srinivas Dabikar
	 * @version 1.1
     */

  private final Class<G> type;

  public EnumTypeHandler(Class<G> type) {
    if (type == null) {
      throw new IllegalArgumentException("Type argument cannot be null");
    }
    this.type = type;
  }

  @Override
  public void setNonNullParameter(PreparedStatement ps, int parameterIndex, G parameter, JdbcType jdbcType) throws SQLException {
    if (jdbcType == null) {
      ps.setString(parameterIndex, null);
    } else {
         ps.setObject(parameterIndex, parameter.name(), Types.OTHER);
    }
  }

  @Override
  public G getNullableResult(ResultSet rs, String columnName) throws SQLException {
	  String s = rs.getString(columnName);
    
   return s == null ? null : Enum.valueOf(type, s);
   
  }

  @Override
  public G getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
    String s = rs.getString(columnIndex);
    return s == null ? null : Enum.valueOf(type, s);
  }

  @Override
  public G getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
    String s = cs.getString(columnIndex);
    return s == null ? null : Enum.valueOf(type, s);
  }
}