package entity.media;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import entity.db.AIMSDB;
import utils.Utils;

/**
 * The general media class, for another media it can be done by inheriting this class
 * @author nguyenlm
 */
public class Media {
    //Nguyen Hoang Anh 20180010
    private static Logger LOGGER = Utils.getLogger(Media.class.getName());

    protected Statement stm;
    protected int id;
    protected String title;
    protected String category;
    protected int value; // the real price of product (eg: 450)
    protected int price; // the price which will be displayed on browser (eg: 500)
    protected int quantity;
    protected String type;
    protected String imageURL;
    protected float length;
    protected float width;
    protected float height;
    protected float weight;

    public Media() throws SQLException{
        stm = AIMSDB.getConnection().createStatement();
    }

    public Media (int id, String title, String category, int price, int quantity, String type) throws SQLException{
        this.id = id;
        this.title = title;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.type = type;

        //stm = AIMSDB.getConnection().createStatement();
    }

    public int getQuantity() throws SQLException{
        int updated_quantity = getMediaById(id).quantity;
        this.quantity = updated_quantity;
        return updated_quantity;
    }

    public Media getMediaById(int id) throws SQLException{
        String sql = "SELECT * FROM Media ;";
        Statement stm = AIMSDB.getConnection().createStatement();
        ResultSet res = stm.executeQuery(sql);
		if(res.next()) {

            return new Media()
                    .setId(res.getInt("id"))
                    .setTitle(res.getString("title"))
                    .setQuantity(res.getInt("quantity"))
                    .setCategory(res.getString("category"))
                    .setMediaURL(res.getString("imageUrl"))
                    .setPrice(res.getInt("price"))
                    .setType(res.getString("type"))
                    .setWeight(res.getFloat("weight"))
                    .setHeight(res.getFloat("height"))
                    .setLength(res.getFloat("length"))
                    .setWidth(res.getFloat("width"));
        }
        return null;
    }

    public List getAllMedia() throws SQLException{
        Statement stm = AIMSDB.getConnection().createStatement();
        ResultSet res = stm.executeQuery("select * from Media");
        ArrayList medium = new ArrayList<>();
        while (res.next()) {
            Media media = new Media()
                .setId(res.getInt("id"))
                .setTitle(res.getString("title"))
                .setQuantity(res.getInt("quantity"))
                .setCategory(res.getString("category"))
                .setMediaURL(res.getString("imageUrl"))
                .setPrice(res.getInt("price"))
                .setType(res.getString("type"));
            medium.add(media);
        }
        return medium;
    }

    public void updateMediaFieldById(String tbname, int id, String field, Object value) throws SQLException {
        Statement stm = AIMSDB.getConnection().createStatement();
        if (value instanceof String){
            value = "\"" + value + "\"";
        }
        stm.executeUpdate(" update " + tbname + " set" + " " 
                          + field + "=" + value + " " 
                          + "where id=" + id + ";");
    }

    // getter and setter 
    public int getId() {
        return this.id;
    }

    private Media setId(int id){
        this.id = id;
        return this;
    }

    public String getTitle() {
        return this.title;
    }

    public Media setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getCategory() {
        return this.category;
    }

    public Media setCategory(String category) {
        this.category = category;
        return this;
    }

    public int getPrice() {
        return this.price;
    }

    public Media setPrice(int price) {
        this.price = price;
        return this;
    }

    public String getImageURL(){
        return this.imageURL;
    }

    public Media setMediaURL(String url){
        this.imageURL = url;
        return this;
    }

    public Media setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getType() {
        return this.type;
    }

    public Media setType(String type) {
        this.type = type;
        return this;
    }

    public float getWeight() {
        return this.weight;
    }

    public Media setWeight(float weight) {
        this.weight = weight;
        return this;
    }

    public float getHeight() {
        return this.height;
    }

    public Media setHeight(float height) {
        this.height = height;
        return this;
    }

    public float getWidth() {
        return this.width;
    }

    public Media setWidth(float width) {
        this.width = width;
        return this;
    }

    public float getLenght() {
        return this.length;
    }

    public Media setLength(float length) {
        this.length = length;
        return this;
    }

    public float getAlternativeWeight() {
        return this.length*this.width*this.height/6000;
    }
    @Override
    public String toString() {
        return "{" +
            " id='" + id + "'" +
            ", title='" + title + "'" +
            ", category='" + category + "'" +
            ", price='" + price + "'" +
            ", quantity='" + quantity + "'" +
            ", type='" + type + "'" +
            ", imageURL='" + imageURL + "'" +
            "}";
    }    

}