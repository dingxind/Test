package com.lunz.cpfw.web.services;

import java.util.concurrent.Future;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.lunz.cpfw.core.interaction.PagingOptions;
import com.lunz.cpfw.core.interaction.Query;
import com.lunz.cpfw.core.service.ServiceBase;
import com.lunz.cpfw.core.service.WebApiResult;
import com.lunz.cpfw.web.entities.helloworld;
import com.lunz.cpfw.web.interfaces.IHelloWorldService;
import com.lunz.cpfw.web.mappers.CommonMapper;
import com.lunz.cpfw.web.mappers.helloworldMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService extends ServiceBase<helloworldMapper, helloworld> implements IHelloWorldService {
    @Autowired
    CommonMapper commonMapper;

    @Autowired
    helloworldMapper helloMapper;

    @Async
    @Override
    public Future<helloworld> getHelloWorld1Async(String name) {
        EntityWrapper<helloworld> queryWrapper = new EntityWrapper<>();
        queryWrapper.eq("name", name);
        return new AsyncResult<helloworld>(super.selectOne(queryWrapper));
    }

    @Override
    public WebApiResult getHelloWorld2(String name) {
        super.logger.trace("test trace");
        super.logger.debug("test debug");
        super.logger.info("test info");
        super.logger.error("test error");
        return WebApiResult.ok(helloMapper.queryByName(name));
    }

    @Async
    @Override
    public Future<WebApiResult> queryPagingResult(PagingOptions pagingOptions) {
        AsyncResult<WebApiResult> result = null;

        // 取ID测试
        // String id = commonMapper.GeneratorKey("PPIN");

        // // 取clientId测试
        // ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        // HttpServletRequest request = servletRequestAttributes.getRequest();

        // String clientId = request.getHeader("ClientId");

        //String clientId = super.getClientId();
        
        //CurrentUserDTO userDto = super.getCurrentUser();

        try {
            Query<helloworld> query = new Query<helloworld>(helloMapper, pagingOptions);

            result = new AsyncResult<WebApiResult>(query.buildResult());
        } catch (Exception ex) {
            result = new AsyncResult<WebApiResult>(WebApiResult.error(ex));
        }

        return result;
    }
}