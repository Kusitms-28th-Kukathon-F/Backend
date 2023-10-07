package kusitms.server.domain.tumbler.history.util;

import kusitms.server.domain.tumbler.history.dto.response.HistoryMonthDetailResponseDto;
import kusitms.server.domain.tumbler.history.dto.response.HistoryQuarterDetailResponseDto;

import java.util.Comparator;

public class ListComparatorQuarter implements Comparator<HistoryQuarterDetailResponseDto> {

    @Override
    public int compare(HistoryQuarterDetailResponseDto o1, HistoryQuarterDetailResponseDto o2) {

        if(o1.getTumblerAverage() > o2.getTumblerAverage()){
            return -1;
        }else if(o1.getTumblerAverage() < o2.getTumblerAverage()){
            return 1;
        }else{
            return 0;
        }
    }
}
