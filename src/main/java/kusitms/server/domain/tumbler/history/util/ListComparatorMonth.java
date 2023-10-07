package kusitms.server.domain.tumbler.history.util;

import kusitms.server.domain.tumbler.history.dto.response.HistoryMonthDetailResponseDto;
import kusitms.server.domain.tumbler.history.dto.response.HistoryQuarterDetailResponseDto;

import java.util.Comparator;

public class ListComparatorMonth implements Comparator<HistoryMonthDetailResponseDto> {

    @Override
    public int compare(HistoryMonthDetailResponseDto o1, HistoryMonthDetailResponseDto o2) {

        if(o1.getTumblerCount() > o2.getTumblerCount()){
            return -1;
        }else if(o1.getTumblerCount() < o2.getTumblerCount()){
            return 1;
        }else{
            return 0;
        }
    }

}
