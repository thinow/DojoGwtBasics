package dojo.gwt.server.dao.object;

public class BeerDataObject {

	private String id;
	private String label;
	private String description;
	private double grade;
	private double alcohol;
	private String brewery;
	private String country;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public double getAlcohol() {
		return alcohol;
	}

	public void setAlcohol(double alcohol) {
		this.alcohol = alcohol;
	}

	public String getBrewery() {
		return brewery;
	}

	public void setBrewery(String brewery) {
		this.brewery = brewery;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
