package io.wulfcodes.mvc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import io.wulfcodes.mvc.model.data.ClubData;
import io.wulfcodes.mvc.model.persistent.Club;

@Service
public class ClubServiceImpl implements ClubService {

    private final List<Club> clubs = new ArrayList<>();

    @Override
    public List<ClubData> findAllClubs() {
        return clubs.stream().map(club -> mapToClubData(club)).collect(Collectors.toList());
    }

    private ClubData mapToClubData(Club club) {
        return ClubData.getBuilder()
            .setId(club.getId())
            .setContent(club.getContent())
            .setPhotoUrl(club.getPhotoUrl())
            .setTitle(club.getTitle())
            .build();
    }
}
