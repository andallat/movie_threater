package com.jpmc.theater;

import java.util.Objects;

public class Reservation {
    private Customer customer;
    private Showing showing;
    private int audienceCount;
    private String resDate;

    public Reservation(Customer customer, Showing showing, int audienceCount, String resDate) {
        this.customer = customer;
        this.showing = showing;
        this.audienceCount = audienceCount;
        this.resDate = resDate;
    }
    
	public double totalFee() {
        //return showing.getMovieFee() * audienceCount;
    	return showing.calculateFee(audienceCount, resDate);
    }

    @Override
	public int hashCode() {
		return Objects.hash(audienceCount, customer, resDate, showing);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		return audienceCount == other.audienceCount && Objects.equals(customer, other.customer)
				&& Objects.equals(resDate, other.resDate) && Objects.equals(showing, other.showing);
	}

	@Override
	public String toString() {
		return "Reservation [customer=" + customer + ", showing=" + showing + ", audienceCount=" + audienceCount
				+ ", resDate=" + resDate + "]";
	}
    
}