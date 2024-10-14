package on.focus0147.service.impl;

import on.focus0147.service.MessageService;
import org.jvnet.hk2.annotations.Service;

@Service
public class MessageServiceImpl implements MessageService {

    @Override
    public String getInfo() {
        return "This is Message Service!";
    }

}