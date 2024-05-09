package db_lab.data;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class Material {

    public final int code;
    public final String description;

    public Material(int code, String description) {
        this.code = code;
        this.description = description == null ? "" : description;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        } else if (other == null) {
            return false;
        } else if (other instanceof Material) {
            var m = (Material) other;
            return (m.code == this.code && m.description.equals(this.description));
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.code, this.description);
    }

    @Override
    public String toString() {
        return Printer.stringify(
            "Material",
            List.of(Printer.field("code", this.code), Printer.field("description", this.description))
        );
    }

    public final class DAO {

        //crea l'oggetto di nostro interesse
        public static Map<Material, Float> forProduct(Connection connection, int productId) {
            var materials = new HashMap<Material, Float>();

            try (
                var statement = connection.prepareStatement(Queries.PRODUCT_COMPOSITION)
                var resultSet = statement.executeQuery();
            ) {
                while(resultSet.next()) {
                    var code = resultSet.getString("m.code");
                    var description = resultSet.getString("m.description");
                    var percent = resultSet.getFloat("c.percent")

                    var material = new Material(code, description);
                    materials.put(material);
                }
                
            } catch (Exception ex) {
                throw new DAOException(ex);
            }
            // Iterating through a resultSet:
            // https://docs.oracle.com/javase/tutorial/jdbc/basics/retrieving.html
            throw new UnsupportedOperationException("Unimplemented");
        }
    }
}
