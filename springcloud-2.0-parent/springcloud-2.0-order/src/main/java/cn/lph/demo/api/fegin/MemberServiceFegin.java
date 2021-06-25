package cn.lph.demo.api.fegin;

import cn.lph.demo.api.service.IMemberService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("eureka-client-member")
public interface MemberServiceFegin extends IMemberService {

}
