package com.cfd.web.impl;

import com.cfd.context.MemberStatus;
import com.cfd.context.ResultCode;
import com.cfd.member.service.impl.MemberServiceImpl;
import com.cfd.pojo.dto.Member;
import com.cfd.pojo.vo.RegisterVo;
import com.cfd.pojo.vo.ResultData;
import com.cfd.util.ResultDataUtil;
import com.cfd.web.MemberController;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @auth snifferhu
 * @date 2018/7/16 22:45
 */
@RestController("/member")
public class MemberControllerImpl implements MemberController {
    private static final Logger logger = LoggerFactory.getLogger(MemberControllerImpl.class);

    @Autowired
    private MemberServiceImpl memberService;

    @PostMapping
    public ResultData register(@RequestBody RegisterVo vo) {
        logger.info("register {}", vo);
        if (StringUtils.isBlank(vo.getUserName())){
            return ResultDataUtil.paramsFail("userName");
        }
        if (StringUtils.isBlank(vo.getPassword())){
            return ResultDataUtil.paramsFail("password");
        }
        memberService.register(Member.createUserByRegisterVo(vo));
        return ResultDataUtil.success();
    }

    @GetMapping
    public ResultData getUser(@RequestParam("id") Optional<String> id, @RequestParam("userName") Optional<String> userName) {
        if (id.isPresent()) {
            Optional<Member> operateMember = memberService.queryById(id.get());
            return ResultDataUtil.success(operateMember.orElse(new Member()));
        } else if (userName.isPresent()) {
            Member member = memberService.queryByUserName(userName.get());
            return ResultDataUtil.success(member);
        } else {
            return ResultDataUtil.fail(ResultCode.PARAMS_FAIL);
        }
    }

    @PatchMapping
    public ResultData updateStatus(@RequestParam("id") Optional<String> id,
                                   @RequestParam("userName") Optional<String> userName,
                                   @RequestParam("status") Optional<String> status) {
        if (status.isPresent()) {
            return ResultDataUtil.paramsFail("status");
        }
        Integer targetStatus = MemberStatus.getCode(status.get());
        if (targetStatus == -1) {
            return ResultDataUtil.statusFail("member");
        }
        if (id.isPresent()) {
            memberService.updateStatusById(id.get(), targetStatus);
            return ResultDataUtil.success();
        } else if (userName.isPresent()) {
            memberService.updateStatusByName(userName.get(), targetStatus);
            return ResultDataUtil.success();
        } else {
            return ResultDataUtil.fail(ResultCode.PARAMS_FAIL);
        }
    }

    @DeleteMapping
    public ResultData delete(@RequestParam("id") Optional<String> id,
                             @RequestParam("userName") Optional<String> userName) {
        if (id.isPresent()) {
            memberService.deleteById(id.get());
            return ResultDataUtil.success();
        } else if (userName.isPresent()) {
            memberService.deleteByUserName(userName.get());
            return ResultDataUtil.success();
        } else {
            return ResultDataUtil.fail(ResultCode.PARAMS_FAIL);
        }

    }
}
