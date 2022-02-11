package assignment_1;

public interface TableHolders{}

class Actor{
    String actor_id;
    String first_name;
    String last_name;
    String last_update;
    public String getActorId() {
        return actor_id;
    }
    public void setActorId(String actor_id) {
        this.actor_id = actor_id;
    }
    public String getFirstName() {
        return first_name;
    }
    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }
    public String getLastName() {
        return last_name;
    }
    public void setLastName(String last_name) {
        this.last_name = last_name;
    }
    public String getLast_update() {
        return last_update;
    }
    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }
}

class Address{
    String address_id;
    String address;
    String address2;
    public String getAddressId() {
        return address_id;
    }
    public void setAddressId(String address_id) {
        this.address_id = address_id;
    }
    public String getAddress1() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress2() {
        return address2;
    }
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

}

class Category{
    String category_id;
    String name;
    String last_update;
    public String getCategoryId() {
        return category_id;
    }
    public void setCategoryId(String category_id) {
        this.category_id = category_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLast_update() {
        return last_update;
    }
    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }
}

class City{
    String city_id;
    String city_name;
    String country_id;
    public String getCityId() {
        return city_id;
    }
    public void setCityId(String city_id) {
        this.city_id = city_id;
    }
    public String getCityName() {
        return city_name;
    }
    public void setCityName(String city_name) {
        this.city_name = city_name;
    }
    public String getCountryId() {
        return country_id;
    }
    public void setCountryId(String country_id) {
        this.country_id = country_id;
    }
}

class Country{
    String country_id;
    String country;
    String last_update;
    public String getCountry_id() {
        return country_id;
    }
    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getLast_update() {
        return last_update;
    }
    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }
}

class Customer{
    String customer_id;
    String store_id;
    String first_name;
    String second_name;
    String email;
    String address_id;
    String active;
    String create_date;
    String last_update;
    public String getCustomerId() {
        return customer_id;
    }
    public void setCustomerId(String customer_id) {
        this.customer_id = customer_id;
    }
    public String getStoreId() {
        return store_id;
    }
    public void setStoreId(String store_id) {
        this.store_id = store_id;
    }
    public String getFirstName() {
        return first_name;
    }
    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }
    public String getSecondName() {
        return second_name;
    }
    public void setSecondName(String second_name) {
        this.second_name = second_name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddressId() {
        return address_id;
    }
    public void setAddressId(String address_id) {
        this.address_id = address_id;
    }
    public String getActive(){
        return active;
    }
    public void setActive(String active){
        this.active=active;
    }
    public String getCreateDate() {
        return create_date;
    }
    public void setCreateDate(String create_date) {
        this.create_date = create_date;
    }
    public String getLast_update() {
        return last_update;
    }
    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }
}

class Film{
    String film_id;
    String title;
    String description;
    String release_year;
    String language_id;
    String original_language_id;
    String rental_duration;
    String rental_rate;
    String length;
    String replacement_cost;
    String rating;
    String special_features;
    String last_update;
    public String getFilm_id() {
        return film_id;
    }
    public void setFilm_id(String film_id) {
        this.film_id = film_id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getrelease_year() {
        return release_year;
    }
    public void setrelease_year(String release_year) {
        this.release_year = release_year;
    }
    public String getLanguageId() {
        return language_id;
    }
    public void setLanguageId(String language_id) {
        this.language_id = language_id;
    }
    public String getOriginal_language_id() {
        return original_language_id;
    }
    public void setOriginal_language_id(String original_language_id) {
        this.original_language_id = original_language_id;
    }
    public String getRental_duration() {
        return rental_duration;
    }
    public void setRental_duration(String rental_duration) {
        this.rental_duration = rental_duration;
    }
    public String getRental_rate() {
        return rental_rate;
    }
    public void setRental_rate(String rental_rate) {
        this.rental_rate = rental_rate;
    }
    public String getLength() {
        return length;
    }
    public void setLength(String length) {
        this.length = length;
    }
    public String getReplacement_cost() {
        return replacement_cost;
    }
    public void setReplacement_cost(String replacement_cost) {
        this.replacement_cost = replacement_cost;
    }
    public String getRating() {
        return rating;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }
    public String getSpeacial_features() {
        return special_features;
    }
    public void setSpeacial_features(String special_features) {
        this.special_features = special_features;
    }
    public String getLast_update() {
        return last_update;
    }
    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }
}

class FilmActor{
    String actor_id;
    String film_id;
    String last_update;
    public String getActorId() {
        return actor_id;
    }
    public void setActorId(String actor_id) {
        this.actor_id = actor_id;
    }
    public String getFilmId() {
        return film_id;
    }
    public void setFilmId(String film_id) {
        this.film_id = film_id;
    }
    public String getLast_update() {
        return last_update;
    }
    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }
}
class FilmCategory{
    String actor_id;
    String category_id;
    String last_update;
    public String getActorId() {
        return actor_id;
    }
    public void setActorId(String actor_id) {
        this.actor_id = actor_id;
    }
    public String getCategoryId() {
        return category_id;
    }
    public void setCategoryId(String category_id) {
        this.category_id = category_id;
    }
    public String getLast_update() {
        return last_update;
    }
    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }
}

class FilmText{
    String film_id;
    String title;
    String description;
    public String getFilmId() {
        return film_id;
    }
    public void setFilmId(String film_id) {
        this.film_id = film_id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}

class Inventory{
    String inventory_id;
    String film_id;
    String store_id;
    String last_update;
    public String getFilmId() {
        return film_id;
    }
    public void setFilmId(String film_id) {
        this.film_id = film_id;
    }
    public String getInventoryId() {
        return inventory_id;
    }
    public void setInventoryId(String inventory_id) {
        this.inventory_id = inventory_id;
    }
    public String getLast_update() {
        return last_update;
    }
    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }
    public String getStoreId() {
        return store_id;
    }
    public void setStoreId(String store_id) {
        this.store_id = store_id;
    }
}

class Language{
    String language_id;
    String name;
    String last_update;
    public String getLanguage_id() {
        return language_id;
    }
    public void setLanguage_id(String language_id) {
        this.language_id = language_id;
    }
    public String getLast_update() {
        return last_update;
    }
    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

class Payment{
    String payment_id;
    String customer_id;
    String staff_id;
    String rental_id;
    String amount;
    String payment_date;
    String last_update;
    public void setAmount(String amount) {
        this.amount = amount;
    }
    public String getAmount() {
        return amount;
    }
    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }
    public String getCustomer_id() {
        return customer_id;
    }
    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }
    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }
    public void setPayment_id(String payment_id) {
        this.payment_id = payment_id;
    }
    public void setRental_id(String rental_id) {
        this.rental_id = rental_id;
    }
    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }
    public String getLast_update() {
        return last_update;
    }
    public String getPayment_date() {
        return payment_date;
    }
    public String getPayment_id() {
        return payment_id;
    }
    public String getRental_id() {
        return rental_id;
    }
    public String getStaff_id() {
        return staff_id;
    }
}

class Rental{
    String rental_id;
    String rental_date;
    String inventory_id;
    String customer_id;
    String return_date;
    String staff_id;
    String last_update;
    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }
    public void setInventory_id(String inventory_id) {
        this.inventory_id = inventory_id;
    }
    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }
    public void setRental_date(String rental_date) {
        this.rental_date = rental_date;
    }
    public void setRental_id(String rental_id) {
        this.rental_id = rental_id;
    }
    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }
    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }
    public String getCustomer_id() {
        return customer_id;
    }
    public String getInventory_id() {
        return inventory_id;
    }
    public String getLast_update() {
        return last_update;
    }
    public String getRental_date() {
        return rental_date;
    }
    public String getRental_id() {
        return rental_id;
    }
    public String getReturn_date() {
        return return_date;
    }
    public String getStaff_id() {
        return staff_id;
    }
}

class Staff{
    String staff_id;
    String first_name;
    String last_name;
    String address_id;
    String picture;
    String email;
    String store_id;
    String active;
    String username;
    String password;
    String last_update;
    public void setActive(String active) {
        this.active = active;
    }
    public void setAddress_id(String address_id) {
        this.address_id = address_id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }
    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }
    public void setStore_id(String store_id) {
        this.store_id = store_id;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getActive() {
        return active;
    }
    public String getAddress_id() {
        return address_id;
    }
    public String getEmail() {
        return email;
    }
    public String getFirst_name() {
        return first_name;
    }
    public String getLast_name() {
        return last_name;
    }
    public String getLast_update() {
        return last_update;
    }
    public String getPassword() {
        return password;
    }
    public String getPicture() {
        return picture;
    }
    public String getStaff_id() {
        return staff_id;
    }
    public String getStore_id() {
        return store_id;
    }
    public String getUsername() {
        return username;
    }
}

class Store{
    String store_id;
    String manager_staff_id;
    String address_id;
    String last_update;
    public void setAddress_id(String address_id) {
        this.address_id = address_id;
    }
    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }
    public void setManager_staff_id(String manager_staff_id) {
        this.manager_staff_id = manager_staff_id;
    }
    public void setStore_id(String store_id) {
        this.store_id = store_id;
    }
    public String getAddress_id() {
        return address_id;
    }
    public String getLast_update() {
        return last_update;
    }
    public String getManager_staff_id() {
        return manager_staff_id;
    }
    public String getStore_id() {
        return store_id;
    }
}