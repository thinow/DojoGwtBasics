package dojo.gwt.server;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import dojo.gwt.server.dao.BeerDAO;
import dojo.gwt.server.dao.object.BeerDataObject;
import dojo.gwt.shared.rpc.object.BeerReference;
import dojo.gwt.shared.rpc.service.BeerService;

public class BeerServiceImpl extends RemoteServiceServlet implements
		BeerService {

	private static final long serialVersionUID = 4685407513958591487L;

	private BeerDAO beerDAO = new BeerDAO();

	@Override
	public BeerReference[] getTopBeers(Integer count) throws Exception {
		List<BeerDataObject> beers = beerDAO.getBestBeers(count);

		return beersReferencesOf(beers);
	}

	private BeerReference[] beersReferencesOf(List<BeerDataObject> beers) {
		int size = beers.size();
		List<BeerReference> references = new ArrayList<BeerReference>(size);
		for (BeerDataObject beer : beers) {
			references.add(beerReferenceOf(beer));
		}

		return references.toArray(new BeerReference[size]);
	}

	private BeerReference beerReferenceOf(BeerDataObject beer) {
		BeerReference reference = new BeerReference();
		reference.setId(beer.getId());
		reference.setLabel(beer.getLabel());

		return reference;
	}

}
