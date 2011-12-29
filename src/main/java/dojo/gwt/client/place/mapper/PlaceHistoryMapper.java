package dojo.gwt.client.place.mapper;

import com.google.gwt.place.shared.WithTokenizers;

import dojo.gwt.client.place.MainPlace;
import dojo.gwt.client.place.MenuPlace;

@WithTokenizers({ MainPlace.Tokenizer.class, MenuPlace.Tokenizer.class })
public interface PlaceHistoryMapper extends
		com.google.gwt.place.shared.PlaceHistoryMapper {

}
