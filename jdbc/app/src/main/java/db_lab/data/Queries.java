package db_lab.data;

public final class Queries {

    public static final String TAGS_FOR_PRODUCT =
        """
        SELECT t.tag_name
        FROM TAGGED t
        wheres
        """;

    public static final String LIST_PRODUCTS =
        """
        SELECT p.code, p.name
        FROM PRODUCT p
        """;

    public static final String PRODUCT_COMPOSITION =
        """
        select m.code, m.description, c.percent
        from PRODUCT p, COMPOSITION c, MATERIAL m
        where c.material_code=m.code 
        and c.product_code=p.code
        """;

    public static final String FIND_PRODUCT =
        """
        select p.code, p.name, p.description
        from PRODUCT p
        """;
}
