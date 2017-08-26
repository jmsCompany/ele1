package qingyun.ele.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csvreader.CsvReader;

import qingyun.ele.SecurityUtils;
import qingyun.ele.domain.db.Location;
import qingyun.ele.domain.db.SubLocation;
import qingyun.ele.domain.db.SubSubLocation;
import qingyun.ele.domain.db.Users;
import qingyun.ele.repository.LocationRepository;
import qingyun.ele.repository.SubLocationRepository;
import qingyun.ele.repository.SubSubLocationRepository;
import qingyun.ele.ws.WSSelectObj;

@Service
@Transactional
public class LocationService {

	@Autowired
	private LocationRepository locationRepository;
	@Autowired
	private SubLocationRepository subLocationRepository;
	@Autowired
	private SubSubLocationRepository subSubLocationRepository;
	@Autowired
	private SecurityUtils securityUtils;

	@Transactional(readOnly = true)
	public List<WSSelectObj> getLocations(Long enabled) {
		List<Location> locations;
		if (enabled == null) {
			locations = locationRepository.findAll();
		} else {
			locations = locationRepository.findByEnabled(enabled);
		}
		List<WSSelectObj> ws = new ArrayList<WSSelectObj>(0);
		WSSelectObj w1 = new WSSelectObj("", "请选择省");
		ws.add(w1);
		for (Location location : locations) {
			WSSelectObj so = new WSSelectObj();
			so.setId(""+location.getId());
			so.setName(location.getName());
			ws.add(so);
		}
		return ws;
	}

	@Transactional(readOnly = true)
	public List<WSSelectObj> getSublocationsByLocation(Long locationId, Long enabled) {
		List<WSSelectObj> ws = new ArrayList<WSSelectObj>(0);
		List<SubLocation> subLocations;
		if (enabled == null) {
			subLocations = subLocationRepository.findByLocationId(locationId);
		} else {
			subLocations = subLocationRepository.findByLocationIdAndEnabled(locationId, enabled);
		}
		WSSelectObj w1 = new WSSelectObj("", "请选择市县");
		ws.add(w1);
		for (SubLocation s : subLocations) {
			WSSelectObj so = new WSSelectObj(""+s.getId(), s.getName());
			ws.add(so);
		}
		return ws;
	}

	@Transactional(readOnly = true)
	public List<WSSelectObj> getSubSublocations(Long subLocationId, Long enabled) {
		List<WSSelectObj> ws = new ArrayList<WSSelectObj>(0);
		List<SubSubLocation> subSubLocations;
		if (enabled == null) {
			subSubLocations = subSubLocationRepository.findBySubLocationId(subLocationId);
		} else {
			subSubLocations = subSubLocationRepository.findBySubLocationIdAndEnabled(subLocationId, enabled);

		}
		WSSelectObj w1 = new WSSelectObj("", "请选择区域");
		ws.add(w1);
		for (SubSubLocation s : subSubLocations) {
			WSSelectObj so = new WSSelectObj(""+s.getId(), s.getName());
			ws.add(so);

		}
		return ws;
	}

	@Transactional(readOnly = true)
	public List<WSSelectObj> getSubSublocations() {
		Users sessionUser = securityUtils.getCurrentDBUser();
		List<WSSelectObj> ws = new ArrayList<WSSelectObj>(0);
		WSSelectObj w1 = new WSSelectObj("", "请选择区域");
		ws.add(w1);
		for (SubSubLocation s : subSubLocationRepository.findByEnabledAndRoleId(1l, sessionUser.getId())) {
			WSSelectObj so = new WSSelectObj(""+s.getId(), s.getSubLocation().getLocation().getName() + ","
					+ s.getSubLocation().getName() + "," + s.getName());
			ws.add(so);

		}
		return ws;
	}

	public void loadLocationsFromCSV(InputStream inputStream) throws IOException {
		CsvReader reader = new CsvReader(inputStream, ',', Charset.forName("UTF-8"));
		// reader.readHeaders(); //Parent, Name, Description
		while (reader.readRecord()) {
			Location l = new Location();
			l.setId(Long.parseLong(reader.get(0).trim()));
			l.setName(reader.get(1).trim());
			// l.setEnabled(Long.parseLong(reader.get(2).trim()));
			l.setEnabled(0l);
			locationRepository.save(l);

		}
	}

	public void loadSubLocationsFromCSV(InputStream inputStream) throws IOException {
		CsvReader reader = new CsvReader(inputStream, ',', Charset.forName("UTF-8"));
		// reader.readHeaders(); //Parent, Name, Description
		while (reader.readRecord()) {
			Long idSubLocation = Long.parseLong(reader.get(0).trim());
			String name = reader.get(1).trim();
			// String postcode =reader.get(2).trim();
			Long locationId = Long.parseLong(reader.get(3).trim());
			// Long enabled = Long.parseLong(reader.get(4).trim());
			Location location = locationRepository.findOne(locationId);
			SubLocation s = new SubLocation();
			s.setName(name);
			s.setId(idSubLocation);
			// s.setEnabled(enabled);
			s.setEnabled(0l);
			s.setLocation(location);
			subLocationRepository.save(s);

		}
	}

	public void loadSubSubFromCSV(InputStream inputStream) throws IOException {
		CsvReader reader = new CsvReader(inputStream, ',', Charset.forName("UTF-8"));
		// reader.readHeaders(); //Parent, Name, Description
		while (reader.readRecord()) {
			Long idDistrict = Long.parseLong(reader.get(0).trim());
			String sdistrict = reader.get(1).trim();

			Long idCity = Long.parseLong(reader.get(2).trim());
			SubLocation city = subLocationRepository.findOne(idCity);
			SubSubLocation district = new SubSubLocation();
			district.setId(idDistrict);
			district.setName(sdistrict);
			district.setSubLocation(city);
			district.setEnabled(0l);
			subSubLocationRepository.save(district);

		}
	}
}
