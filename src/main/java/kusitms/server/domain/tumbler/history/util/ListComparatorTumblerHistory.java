package kusitms.server.domain.tumbler.history.util;

import kusitms.server.domain.tumbler.history.dto.response.HistoryQuarterDetailResponseDto;
import kusitms.server.domain.tumbler.history.entity.TumblerHistory;

import java.util.Comparator;

public class ListComparatorTumblerHistory implements Comparator<TumblerHistory> {

    @Override
    public int compare(TumblerHistory o1, TumblerHistory o2) {

        if(o1.getTumblerCount() > o2.getTumblerCount()){
            return -1;
        }else if(o1.getTumblerCount() < o2.getTumblerCount()){
            return 1;
        }else{
            return 0;
        }
    }
}
