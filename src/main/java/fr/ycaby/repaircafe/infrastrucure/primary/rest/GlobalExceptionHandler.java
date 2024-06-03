package fr.ycaby.repaircafe.infrastrucure.primary.rest;

import fr.ycaby.repaircafe.core.exception.DeviceAbsentException;
import fr.ycaby.repaircafe.core.exception.DeviceAlreadyPresentException;
import fr.ycaby.repaircafe.core.exception.MemberAbsentException;
import fr.ycaby.repaircafe.core.exception.MemberAlreadyPresentException;
import fr.ycaby.repaircafe.core.exception.MemberMembershipAbsentException;
import fr.ycaby.repaircafe.core.exception.MemberRoleAbsentExpception;
import fr.ycaby.repaircafe.core.exception.MemberRoleAlreadyPresentException;
import fr.ycaby.repaircafe.core.exception.MembershipAlreadyPresentException;
import fr.ycaby.repaircafe.core.exception.RepairAbsentException;
import fr.ycaby.repaircafe.core.exception.RepairAlreadyExistException;
import fr.ycaby.repaircafe.core.exception.RepairAlreadyPresentException;
import fr.ycaby.repaircafe.core.exception.RepairListAbsentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MemberAlreadyPresentException.class)
    public ProblemDetail handleMemberAlreadyPresentException(MemberAlreadyPresentException e){
        return ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, e.getMessage());
    }
    @ExceptionHandler(MemberRoleAlreadyPresentException.class)
    public ProblemDetail handleMemberRoleAlreadyPresentException(MemberRoleAlreadyPresentException e){
        return ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, e.getMessage());
    }
    @ExceptionHandler(MembershipAlreadyPresentException.class)
    public ProblemDetail handleMembershipAlreadyPresentException(MembershipAlreadyPresentException e){
        return ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, e.getMessage());
    }
    @ExceptionHandler(RepairAlreadyPresentException.class)
    public ProblemDetail handleRepairAlreadyPresentException(RepairAlreadyPresentException e){
        return ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, e.getMessage());
    }
    @ExceptionHandler(DeviceAlreadyPresentException.class)
    public ProblemDetail handleDeviceAlreadyPresentException(DeviceAlreadyPresentException e){
        return ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, e.getMessage());
    }
    @ExceptionHandler(RepairAlreadyExistException.class)
    public ProblemDetail handleRepairAlreadyExistException(RepairAlreadyExistException e){
        return ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, e.getMessage());
    }
    @ExceptionHandler(MemberAbsentException.class)
    public ProblemDetail handleMemberAbsentException(MemberAbsentException e){
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
    }
    @ExceptionHandler(MemberMembershipAbsentException.class)
    public ProblemDetail handleMemberMembershipAbsentException(MemberMembershipAbsentException e){
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
    }
    @ExceptionHandler(MemberRoleAbsentExpception.class)
    public ProblemDetail handleMemberRoleAbsentExpception(MemberRoleAbsentExpception e){
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
    }
    @ExceptionHandler(RepairListAbsentException.class)
    public ProblemDetail handleRepairListAbsentException(RepairListAbsentException e){
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
    }
    @ExceptionHandler(RepairAbsentException.class)
    public ProblemDetail handleRepairAbsentException(RepairAbsentException e){
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
    }
    @ExceptionHandler(DeviceAbsentException.class)
    public ProblemDetail handleDeviceAbsentException(DeviceAbsentException e){
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
    }
}
