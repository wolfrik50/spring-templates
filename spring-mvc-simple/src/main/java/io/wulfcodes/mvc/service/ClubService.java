package io.wulfcodes.mvc.service;

import java.util.List;
import io.wulfcodes.mvc.model.data.ClubData;

public interface ClubService {
    List<ClubData> findAllClubs();
}
