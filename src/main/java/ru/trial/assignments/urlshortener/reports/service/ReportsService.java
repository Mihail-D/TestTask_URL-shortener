package ru.trial.assignments.urlshortener.reports.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.trial.assignments.urlshortener.link.model.Link;
import ru.trial.assignments.urlshortener.reports.model.StatisticsResponse;
import ru.trial.assignments.urlshortener.repository.LinkRepository;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ReportsService {

    LinkRepository linkRepository;

    public ReportsService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public Map<String, Long> getTop3Links() {
        List<Link> topLinks = linkRepository.findTop3Links().subList(0, 3);
        return topLinks.stream()
                .collect(Collectors.toMap(Link::getShortLink, Link::getCount));
    }

    public int getPositionInTop(String shortLink) {
        Long[] arr = getTop3Links().values().toArray(Long[]::new);
        Arrays.sort(arr, Collections.reverseOrder());
        int pos = 0;

        if (!getTop3Links().containsKey(shortLink)) {
            return pos;
        }
        else {
            for (int i = 0; i < arr.length; i++) {
                if (Objects.equals(arr[i], getTop3Links().get(shortLink))) {
                    pos = i + 1;
                }
            }
        }
        return pos;
    }

    public StatisticsResponse getLinkInTop(String shortLink) {
        Optional<Link> link = linkRepository.findByShortLink(shortLink);
        StatisticsResponse response = new StatisticsResponse();
        int rank = getPositionInTop(shortLink);

        link.ifPresent(l -> response.setOriginalLink(l.getOriginalLink()));
        link.ifPresent(l -> response.setShortLink(l.getShortLink()));
        link.ifPresent(l -> response.setCount(l.getCount()));
        link.ifPresent(l -> response.setRank(rank));

        return response;
    }
}
