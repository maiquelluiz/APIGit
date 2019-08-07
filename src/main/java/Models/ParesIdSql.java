package Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Objects;

public class ParesIdSql {
    @SerializedName("ultimoId")
    @Expose
    private int ultimoId;

    @SerializedName("SQL")
    @Expose
    private String SQL;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.getUltimoId();
        hash = 47 * hash + Objects.hashCode(this.getSQL());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ParesIdSql other = (ParesIdSql) obj;
        if (this.getUltimoId() != other.getUltimoId()) {
            return false;
        }
        if (!Objects.equals(this.SQL, other.SQL)) {
            return false;
        }
        return true;
    }

    /**
     * @return the ultimoId
     */
    public int getUltimoId() {
        return ultimoId;
    }

    /**
     * @param ultimoId the ultimoId to set
     */
    public void setUltimoId(int ultimoId) {
        this.ultimoId = ultimoId;
    }

    /**
     * @return the SQL
     */
    public String getSQL() {
        return SQL;
    }

    /**
     * @param SQL the SQL to set
     */
    public void setSQL(String SQL) {
        this.SQL = SQL;
    }
    
}
