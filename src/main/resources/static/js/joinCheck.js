/**
 * 회원가입시 각 항목에 대한 입력 유효성 판단
 */
var space = /\s/g;
var title = "";
var join = {
   common: {
      empty: {code: 'invalid', desc: title + '입력하세요.'},
      space: {code: 'invalid', desc: '공백 없이 입력하세요.'},
      min: {code: 'invalid', desc: '최소 5자 이상 입력하세요.'},
      max: {code: 'invalid', desc: '최대 10자 이내로 입력하세요.'}
   },

    memberName: {
        valid: { code:'valid', desc: '유효한 이름입니다.' }
        invalid: { code:'invalid', desc: '한글로만 입력하세요.' }
        min: {code: 'invalid', desc: '최소 2자 이상 입력하세요.' }
    }

    memberName_status: function(memberName) {
        var reg = /^[가-힣]{2,10}$/;
        title = $('[name=memberName]').attr('title');
        if( memberName == '' ) return this.common.empty;
        else if(memberName.match(space)) return this.common.space;
        else if(memberName.length < 2) return this.memberName.min;
        else if( reg.test(memberName) ) return this.memberName.valid;
        else return this.memberName.invalid;
    },

   id: {
      valid: { code:'valid', desc: '아이디를 중복확인하세요.' },
      invalid: { code:'invalid', desc: '아이디는 영문 소문자, 숫자만 입력하세요.' },
      usable: { code: 'valid', desc: '사용 가능한 아이디입니다.'},
      unusable: { code: 'invalid', desc: '이미 사용 중인 아이디입니다.' }
   },

   id_usable: function(data) {
      if(data) return this.memberId.usable;
      else return this.memberId.unusable;
   },

   id_status: function(memberId) {
      var reg = /[^a-z0-9]/g;
      title = $('[name=memberId]').attr('title');
      if(memberId == '') {
         return this.common.empty;
      } else if(memberId.match(space)) {
         return this.common.space;
      } else if(reg.test(memberId)) {
         return this.id.invalid;
      } else if(memberId.length < 5) {
         return this.common.min;
      } else if(memberId.length > 10) {
         return this.common.max;
      } else {
         return this.memberId.valid;
      }
   },

   pw: {
      valid: { code:'valid', desc: '사용 가능한 비밀번호입니다.' },
      invalid: { code:'invalid', desc: '비밀번호는 영문 대/소문자, 숫자만 입력하세요.' },
      lack: { code:'invalid', desc: '비밀번호는 영문 대/소문자, 숫자를 모두 포함해야 합니다.' },
      equal: { code: 'valid', desc: '비밀번호가 일치합니다.' },
      notEqual: { code: 'invalid', desc: '비밀번호가 일치하지 않습니다.' }
   },

   pw_status: function(pw) {
      var reg = /[^a-zA-Z0-9]/g;
      title = $('[name=my_pwd]').attr('title');
      var upper = /[A-Z]/g, lower = /[a-z]/g, digit = /[0-9]/g;
      if(my_pwd == '') return this.common.empty;
      else if(my_pwd.match(space)) return this.common.space;
      else if(reg.test(memberPw)) return this.memberPw.invalid;
      else if(my_pwd.length < 5) return this.common.min;
      else if(my_pwd.length > 10) return this.common.max;
      else if ( !upper.test(pw) || !lower.test(pw) || !digit.test(pw) ) return this.pw.lack;
      else return this.pw.valid;
   },

   pw_ck_status: function(pw_ck) {
      title = $('[name=pwd_check]').attr('title');
      if ( pw_ck=='' ) return this.common.empty;
      else if(pw_ck == $('[name=pwd_check]').val() ) return this.pw.equal;
      else return this.my_pwd.notEqual;
   },

   email: {
      valid: { code: 'valid', desc: '유효한 이메일입니다.' },
      invalid: { code: 'invalid', desc: '유효하지 않은 이메일입니다.' }
   },

   email_status: function(memberEmail) {
      var reg = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
      title = $('[name=memberEmail]').attr('title');
      if( memberEmail == '' ) return this.common.empty;
      else if(memberEmail.match(space)) return this.common.space;
      else if( reg.test(memberEmail) ) return this.memberEmail.valid;
      else return this.email.invalid;
   },

   tag_status: function(tag) {
      var data = tag.val();
      tag = tag.attr('name');
      if(tag == 'id') {
         data = this.id_status(data);
      } else if(tag == 'memberPw') {
         data = this.pw_status(data);
      } else if(tag == 'memberPw2') {
         data = this.pw_ck_status(data);
      } else if(tag == 'memberEmail') {
         data = this.email_status(data);
      }
      return data;
   }
}