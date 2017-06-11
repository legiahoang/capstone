package vn.co.cex.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.primefaces.event.map.GeocodeEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.GeocodeResult;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import javax.annotation.PostConstruct;


@ManagedBean(name = "googleMapView", eager = true)
public class GoogleMapView implements Serializable{

	private MapModel mapModel;
	private String centerGeoMap = "41.850033, -87.6500523";
	
	@PostConstruct
    public void init() {
        mapModel = new DefaultMapModel();
    }
  
	public void onGeocode(GeocodeEvent event) {
        List<GeocodeResult> results = event.getResults();
         
        if (results != null && !results.isEmpty()) {
            LatLng center = results.get(0).getLatLng();
            centerGeoMap = center.getLat() + "," + center.getLng();
             
            for (int i = 0; i < results.size(); i++) {
                GeocodeResult result = results.get(i);
                mapModel.addOverlay(new Marker(result.getLatLng(), result.getAddress()));
            }
        }
    }

	public MapModel getMapModel() {
		return mapModel;
	}

	public void setMapModel(MapModel mapModel) {
		this.mapModel = mapModel;
	}

	public String getCenterGeoMap() {
		return centerGeoMap;
	}

	public void setCenterGeoMap(String centerGeoMap) {
		this.centerGeoMap = centerGeoMap;
	}
}
