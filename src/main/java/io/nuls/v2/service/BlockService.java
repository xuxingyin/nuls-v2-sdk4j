package io.nuls.v2.service;

import io.nuls.core.basic.Result;
import io.nuls.core.constant.ErrorCode;
import io.nuls.v2.model.dto.RestFulResult;
import io.nuls.v2.util.RestFulUtil;

import static io.nuls.v2.util.ValidateUtil.validateChainId;


public class BlockService {

    private BlockService() {

    }

    private static BlockService instance = new BlockService();

    public static BlockService getInstance() {
        return instance;
    }

    public Result getBlockHeader(long height) {
        validateChainId();
        RestFulResult restFulResult = RestFulUtil.get("api/block/header/height/" + height);
        Result result;
        if (restFulResult.isSuccess()) {
            result = io.nuls.core.basic.Result.getSuccess(restFulResult.getData());
        } else {
            ErrorCode errorCode = ErrorCode.init(restFulResult.getError().getCode());
            result = io.nuls.core.basic.Result.getFailed(errorCode).setMsg(restFulResult.getError().getMessage());
        }
        return result;
    }

    public Result getBlockHeader(String hash) {
        validateChainId();
        RestFulResult restFulResult = RestFulUtil.get("api/block/header/hash/" + hash);
        Result result;
        if (restFulResult.isSuccess()) {
            result = io.nuls.core.basic.Result.getSuccess(restFulResult.getData());
        } else {
            ErrorCode errorCode = ErrorCode.init(restFulResult.getError().getCode());
            result = io.nuls.core.basic.Result.getFailed(errorCode).setMsg(restFulResult.getError().getMessage());
        }
        return result;
    }


    public Result getBlock(long height) {
        validateChainId();
        RestFulResult restFulResult = RestFulUtil.get("api/block/height/" + height);
        Result result;
        if (restFulResult.isSuccess()) {
            result = io.nuls.core.basic.Result.getSuccess(restFulResult.getData());
        } else {
            ErrorCode errorCode = ErrorCode.init(restFulResult.getError().getCode());
            result = io.nuls.core.basic.Result.getFailed(errorCode).setMsg(restFulResult.getError().getMessage());
        }
        return result;
    }

    public Result getBlock(String hash) {
        validateChainId();
        RestFulResult restFulResult = RestFulUtil.get("api/block/hash/" + hash);
        Result result;
        if (restFulResult.isSuccess()) {
            result = io.nuls.core.basic.Result.getSuccess(restFulResult.getData());
        } else {
            ErrorCode errorCode = ErrorCode.init(restFulResult.getError().getCode());
            result = io.nuls.core.basic.Result.getFailed(errorCode).setMsg(restFulResult.getError().getMessage());
        }
        return result;
    }

    public Result getBestBlockHeader() {
        validateChainId();
        RestFulResult restFulResult = RestFulUtil.get("api/block/header/newest");
        Result result;
        if (restFulResult.isSuccess()) {
            result = io.nuls.core.basic.Result.getSuccess(restFulResult.getData());
        } else {
            ErrorCode errorCode = ErrorCode.init(restFulResult.getError().getCode());
            result = io.nuls.core.basic.Result.getFailed(errorCode).setMsg(restFulResult.getError().getMessage());
        }
        return result;
    }

    public Result getBestBlock() {
        validateChainId();
        RestFulResult restFulResult = RestFulUtil.get("api/block/newest");
        Result result;
        if (restFulResult.isSuccess()) {
            result = io.nuls.core.basic.Result.getSuccess(restFulResult.getData());
        } else {
            ErrorCode errorCode = ErrorCode.init(restFulResult.getError().getCode());
            result = io.nuls.core.basic.Result.getFailed(errorCode).setMsg(restFulResult.getError().getMessage());
        }
        return result;
    }
}
